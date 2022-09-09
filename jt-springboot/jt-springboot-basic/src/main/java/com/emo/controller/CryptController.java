package com.emo.controller;

import com.emo.starter.config.EmoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherxia92
 * 2022/8/29 0029 下午 14:11
 */
@Slf4j
@RestController
@RequestMapping("/")
public class CryptController {

    @Autowired
    private EmoProperties emoProperties;

    @RequestMapping("/emo-starter")
    public String EmoStarter() {
        System.out.println("emoProperties: " + emoProperties.toString());
        log.debug("hello emo starter");
        log.debug("emoProperties: {}", emoProperties);
        return "emo-starter";
    }

    @RequestMapping("/sha1")
    @ConditionalOnProperty(prefix = "crypt", name = "sh1", havingValue = "true")
    public String sha1(){
        return "sha1";
    }

    @RequestMapping("/aes")
    @ConditionalOnProperty(prefix = "crypt", name = "aes", havingValue = "true")
    public String aes(){
        return "aes";
    }
}
