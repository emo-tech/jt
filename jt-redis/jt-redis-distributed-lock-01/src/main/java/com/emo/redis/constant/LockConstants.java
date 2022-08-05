package com.emo.redis.constant;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 */
@Slf4j
public class LockConstants {
    public static final String OK = "OK";

    /**
     * Only set the key if it does not already exist
     */
    public static final String NOT_EXIST = "NX";

    /**
     * Only set the key if it already exists
     */
    public static final String EXIST = "XX";

    /**
     * expire time units: EX = seconds
     */
    public static final String SECONDS = "EX";

    /**
     * expire time units: PX = milliseconds
     */
    public static final String MILLISECONDS = "PX";

    private LockConstants() {

    }
}
