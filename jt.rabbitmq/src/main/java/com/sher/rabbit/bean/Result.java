package com.sher.rabbit.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success;

    /**
     * 失败消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 结果对象
     */
    private T data;

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMessage("success");
        result.setCode(1);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> success(T t, String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setMessage(msg);
        result.setCode(1);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> failed() {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage("fail");
        result.setCode(-1);
        return result;
    }

    public static <T> Result<T> failed(String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage(msg);
        result.setCode(-1);
        return result;
    }

    public static <T> Result<T> failed(Integer code, String msg) {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setMessage(msg);
        result.setCode(code);
        return result;
    }
}