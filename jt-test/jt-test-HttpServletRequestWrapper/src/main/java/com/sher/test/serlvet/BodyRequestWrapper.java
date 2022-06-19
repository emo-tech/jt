package com.sher.test.serlvet;

import cn.hutool.json.JSONUtil;
import com.sher.test.param.FooParam;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: sherxia92
 * @description: 读取RequestBody里的内容
 */
@Slf4j
public class BodyRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    public BodyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        log.debug("method: [{}]", method);
        log.debug("requestURI: [{}]", requestURI);

        BufferedReader reader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        log.debug("json string: [{}]", json);

        // 数据处理, 添加age属性
        FooParam fooParam = JSONUtil.toBean(json, FooParam.class);
        fooParam.setAge(20);
        json = JSONUtil.toJsonStr(fooParam);

        body = json.getBytes();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    /**
     * 在使用@RequestBody注解的时候，其实框架是调用getInputStream()方法，所以需要重写这个方法
     * @return
     * @throws IOException
     */
    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }
}
