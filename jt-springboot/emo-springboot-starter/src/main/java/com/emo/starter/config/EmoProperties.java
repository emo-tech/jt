package com.emo.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sherxia92
 * 2022/9/9 0009 上午 9:01
 */

@ConfigurationProperties(prefix = "com.emo.properties")
@Data
public class EmoProperties {
    private String propertyA;
    private String propertyB;
}
