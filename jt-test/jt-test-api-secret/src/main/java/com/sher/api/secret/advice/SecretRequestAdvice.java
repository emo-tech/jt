package com.sher.api.secret.advice;

import cn.hutool.json.JSONUtil;
import com.sher.api.secret.bean.RequestSecret;
import com.sher.api.secret.constant.Constants;
import com.sher.api.secret.constant.ResponseCode;
import com.sher.api.secret.exception.ResultException;
import com.sher.api.secret.filter.SecretFilter;
import com.sher.api.secret.http.SecretHttpMessage;
import com.sher.api.secret.util.EncryptUtils;
import com.sher.api.secret.util.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Order;
import org.springframework.core.MethodParameter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * @author sherxia92
 */
@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecretRequestAdvice extends RequestBodyAdviceAdapter {

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        // 如果支持加密消息， 进行消息解密
        String httpBody;
        if (Boolean.TRUE.equals(SecretFilter.secretThreadLocal.get())) {
            httpBody = decryptBody(inputMessage);
        } else {
            httpBody = IOUtils.toString(inputMessage.getBody(), Charset.defaultCharset());
        }
        // 返回处理的消息体给messageConverter
        return new SecretHttpMessage(new ByteArrayInputStream(httpBody.getBytes()), inputMessage.getHeaders());
    }

    /**
     * 解密消息体
     * @param inputMessage
     * @return
     */
    private String decryptBody(HttpInputMessage inputMessage) throws IOException {
        InputStream encryptedStream = inputMessage.getBody();
        String requestBody = IOUtils.toString(encryptedStream, Charset.defaultCharset());
        // 验签过程
        HttpHeaders headers = inputMessage.getHeaders();
        if (CollectionUtils.isEmpty(headers.get(Constants.STRING_CLIENT_TYPE))
                || CollectionUtils.isEmpty(headers.get("timestamp"))
                || CollectionUtils.isEmpty(headers.get("salt"))
                || CollectionUtils.isEmpty(headers.get("signatrue"))
        ) {
            new ResultException(ResponseCode.SECRET_API_ERROR.getCode(), ResponseCode.SECRET_API_ERROR.getErrorMessage());
        }

        String timestamp = String.valueOf(Objects.requireNonNull(headers.get(Constants.STRING_TIMESTAMP)).get(0));
        String salt = String.valueOf(Objects.requireNonNull(headers.get(Constants.STRING_SALT)).get(0));
        String signature = String.valueOf(Objects.requireNonNull(headers.get(Constants.STRING_SIGNATURE)).get(0));
        String privateKey = SecretFilter.clientPrivateKeyThreadLocal.get();
        RequestSecret requestSecret = JSONUtil.toBean(requestBody, RequestSecret.class);
        String data = requestSecret.getData();
        String newSignature = "";
        if (!StringUtils.hasLength(signature)) {
            newSignature = Md5Utils.genSignature(timestamp + salt + data + privateKey);
        }
        if (!newSignature.equals(signature)) {
            // 验签失败
            throw new ResultException(ResponseCode.SECRET_SIGNATURE_ERROR.getCode(), ResponseCode.SECRET_SIGNATURE_ERROR.getErrorMessage());
        }

        try {
            String decrypt = EncryptUtils.aesDecrypt(data, privateKey);
            if (!StringUtils.hasLength(decrypt)) {
                decrypt = "{}";
            }
            return decrypt;
        } catch (Exception e) {
            log.error("", e);
        }
        throw new ResultException(ResponseCode.SECRET_DECRYPT_ERROR.getCode(), ResponseCode.SECRET_DECRYPT_ERROR.getErrorMessage());
    }
}
