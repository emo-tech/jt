package com.sher.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.nio.charset.StandardCharsets;

/**
 * websocket消息处理类
 * @author sherxia92
 */
@Slf4j
public class EchoTextWebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 收到的消息
        String requestMsg = message.getPayload();
        log.debug("服务器收到：{}", requestMsg);
        // 返回消息
        String responseMsg = "服务器返回：" + requestMsg;
        log.debug("{}", responseMsg);
        TextMessage textMessage = new TextMessage(responseMsg.getBytes(StandardCharsets.UTF_8));
        // 返回给客户端
        session.sendMessage(textMessage);
    }
}
