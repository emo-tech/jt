package com.sher.api.secret.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResponseCode {
    SECRET_API_ERROR(4001, "请求解密参数错误，clientType、timestamp、salt、signature等参数传递是否正确传递"),
    SECRET_SIGNATRUE_ERROR(4001, "验签失败，请确认加密方式是否正确");

    private Integer code;
    private String errorMessage;

}
