package com.emo.wms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherxia92
 * 2022/8/22 0022 下午 16:19
 */
@RestController
@RequestMapping(value = "/wms")
public class WmsController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "wms test";
    }
}
