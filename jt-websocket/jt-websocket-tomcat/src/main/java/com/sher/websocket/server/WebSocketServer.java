package com.sher.websocket.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sher.websocket.dto.InMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * from: https://blog.csdn.net/qq_31960623/article/details/114131424
 * @author sherxia92
 */
@Slf4j
@Component
@ServerEndpoint("/api/push-message/{userId}")
public class WebSocketServer {

    /**
     * 在线连接数
     */
    private static int onlineCount = 0;

    /**
     * 线程安全的存储 每个客户端对应的WebSocket
     */
    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    /**
     * 客户端会话连接
     */
    private Session session;

    /**
     * userId
     */
    private String userId;

    /**
     * 连接建立成功后调用
     * @param session
     * @param userId
     */
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            webSocketMap.put(userId, this);
        } else {
            webSocketMap.put(userId, this);
            // 在线数增加
            addOnlineCount();
        }
        log.info("用户连接: [{}],当前在线人数为: [{}]", userId, getOnlineCount());
        sendMessage("连接成功");
    }

    /**
     * 连接关闭时调用
     */
    @OnClose
    public void onClose() {
        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            subOnlineCount();
        }
        log.info("用户退出: [{}], 当前在线人数为: [{}]",  userId, getOnlineCount());
    }

    /**
     * 收到客户端消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) throws JsonProcessingException {
        log.info("用户消息：[{}], 报文： [{}]", userId, message);
        if (!StringUtils.isEmpty(message)) {
            InMessageDTO inMessage = new ObjectMapper().readValue(message, InMessageDTO.class);
            String toUser = inMessage.getToUser();
            if (!StringUtils.isEmpty(toUser) && webSocketMap.containsKey(toUser)) {
                webSocketMap.get(toUser).sendMessage(message);
            } else {
                log.error("请求的用户[{}]不在线", toUser);
            }

        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误: [{}], 原因: [{}]", this.userId, error.getMessage());
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("", e);
        }
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
}
