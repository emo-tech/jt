package com.sher.api.secret.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sher.api.secret.constant.UserType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author sherxia92
 */
@Data
public class User {
    private Integer id;
    private String name;
    private UserType userType = UserType.COMMON;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerTime;
}
