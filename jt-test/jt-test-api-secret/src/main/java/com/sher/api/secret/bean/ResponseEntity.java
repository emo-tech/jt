package com.sher.api.secret.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sherxia92
 */
@Data
public class ResponseEntity<T> implements Serializable {
    private int code;
    private T data;
    private String msg;
    private int salt;
    private String signature;

    public ResponseEntity<T> fail(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResponseEntity<T> success(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }
}
