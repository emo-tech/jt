package com.emo.rabbitmq.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.emo.rabbitmq.bean.Result;
import com.emo.rabbitmq.work.DirectSender;
import com.emo.rabbitmq.work.FanoutSender;
import com.emo.rabbitmq.work.SimpleSender;
import com.emo.rabbitmq.work.WorkSender;
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
    @Autowired
    private WorkSender workSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private DirectSender directSender;

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

    @ApiOperation("工作模式")
    @RequestMapping(value = "/work", method = RequestMethod.GET)
    public Result workTest() {
        for (int i =0; i< 10; i++) {
            workSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return Result.success(null);
    }

    @ApiOperation("发布/订阅模式")
    @RequestMapping(value = "/fanout", method = RequestMethod.GET)
    public Result fanoutTest() {
        for (int i =0; i< 10; i++) {
            fanoutSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return Result.success(null);
    }

    @ApiOperation("路由模式")
    @RequestMapping(value = "/direct", method = RequestMethod.GET)
    public Result directTest() {
        for (int i=0; i<10; i++) {
            directSender.send(i);
            ThreadUtil.sleep(10000);
        }
        return Result.success(null);
    }
}
