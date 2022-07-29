package com.sher.api.secret.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sherxia92
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecretHttpMessage implements HttpInputMessage {

    private InputStream inputStream;
    private HttpHeaders httpHeaders;

    @Override
    public InputStream getBody() throws IOException {
        return this.inputStream;
    }

    @Override
    public HttpHeaders getHeaders() {
        return this.httpHeaders;
    }
}
