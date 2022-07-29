package com.sher.api.secret.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author sherxia92
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultException extends RuntimeException implements Serializable {
    private Integer code;
    private String msg;
}
