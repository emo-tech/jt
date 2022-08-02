package com.sher.api.secret.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sher.api.secret.bean.ResponseEntity;
import com.sher.api.secret.bean.SecretResponseBasic;
import com.sher.api.secret.constant.ResponseCode;
import com.sher.api.secret.filter.SecretFilter;
import com.sher.api.secret.util.EncryptUtils;
import com.sher.api.secret.util.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author sherxia92
 */
@Slf4j
@ControllerAdvice
public class SecretResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 判断是否需要加密
        Boolean responseSecret = SecretFilter.secretThreadLocal.get();
        String secretKey = SecretFilter.clientPrivateKeyThreadLocal.get();
        // 清理本地缓存
        SecretFilter.secretThreadLocal.remove();
        SecretFilter.clientPrivateKeyThreadLocal.remove();

        if (Boolean.TRUE.equals(responseSecret) && (body instanceof ResponseEntity)) {
            ResponseEntity responseBody = (ResponseEntity) body;
            if (ResponseCode.SECRET_API_ERROR.getCode().equals(responseBody.getCode())) {
                return SecretResponseBasic.fail(responseBody.getCode(), responseBody.getData(), responseBody.getMsg());
            }
            // 业务逻辑
            try {
                String data = EncryptUtils.aesEncrypt(objectMapper.writeValueAsString(responseBody), secretKey);
                // 增加签名
                long timestamp = System.currentTimeMillis() / 1000;
                int salt = EncryptUtils.genSalt();
                String dataNew = timestamp + "" + salt + "" + data + secretKey;
                String newSignature = Md5Utils.genSignature(dataNew);
                return SecretResponseBasic.success(data, timestamp, salt, newSignature);
            } catch (Exception e) {
                log.error("", e);
                return SecretResponseBasic.fail(ResponseCode.SECRET_API_ERROR.getCode(), "", "服务端处理结果数据异常");
            }
        }
        return body;
    }
}
