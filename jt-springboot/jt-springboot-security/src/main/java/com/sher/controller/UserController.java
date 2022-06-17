package com.sher.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherxia92
 */

@RestController
public class UserController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
