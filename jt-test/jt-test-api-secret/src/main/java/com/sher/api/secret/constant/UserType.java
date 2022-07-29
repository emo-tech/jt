package com.sher.api.secret.constant;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

/**
 * @author sherxia92
 */

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  UserType {
    VIP("VIP用户"),
    COMMON("普通用户");

    private String code;
    private String type;

    UserType(String type) {
        this.code = name();
        this.type = type;
    }
}
