package com.sher.test.annotation.common;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 */
@Slf4j
@Data
@ToString
public class User {
    private String name = "default";
}
