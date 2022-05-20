package com.sher.websocket;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


/**
 * 配置类
 * @author sherxia92
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        // 为指定的handler 匹配具体的WebSocketHandler
        WebSocketHandlerRegistration registration = webSocketHandlerRegistry.addHandler(echoHandler(), "/echo");
    }

    @Bean
    public WebSocketHandler echoHandler() {
        return new EchoTextWebSocketHandler();
    }
}
