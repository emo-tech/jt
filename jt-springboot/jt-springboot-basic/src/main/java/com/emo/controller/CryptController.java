package com.emo.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherxia92
 * 2022/8/29 0029 下午 14:11
 */
@RestController
@RequestMapping("/")
public class CryptController {

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
