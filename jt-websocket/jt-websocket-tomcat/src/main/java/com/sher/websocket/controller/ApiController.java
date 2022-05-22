package com.sher.websocket.controller;

import com.sher.websocket.service.impl.WebSocketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sherxia92
 */
@Slf4j
@Controller
@RequestMapping(value ="/api")
public class ApiController {

    @Autowired
    private WebSocketServiceImpl webSocketService;

    /**
     * 启动页面
     * @return
     */
    @GetMapping("/start")
    public String start(){
        return "start";
    }


//    @PostMapping("/pushToWeb")
//    @ApiOperation(value = "服务器端向客户端推送消息", notes = "服务器端向客户端推送消息")
//    public Result pushToWeb(@RequestBody @ApiParam(value = "回收人编码和医院编码", required = true) CodesInfo info){
//        webSocketService.printTime();
//        return null;
//    }
}
