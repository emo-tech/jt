package com.sher.api.secret.bean;

import lombok.Data;

/**
 * @author sherxia92
 */
@Data
public class ResponseEntity<T> {
    private int code;
    private T data;
    private String msg;
}
