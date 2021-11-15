package com.sher.rabbit.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.sher.rabbit.bean.Result;
import com.sher.rabbit.work.SimpleSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-12 16:29
 */
@Api(tags = "RabbitController", description = "RabbitMQ功能测试")
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private SimpleSender simpleSender;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }

    @ApiOperation("简单模式")
    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public Result simpleTest() {
        for (int i = 0; i < 10; i++) {
            simpleSender.send();
            ThreadUtil.sleep(1000);
        }
        return Result.success(null);
    }
}
