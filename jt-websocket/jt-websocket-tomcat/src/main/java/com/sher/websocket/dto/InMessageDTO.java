package com.sher.websocket.dto;

import lombok.Data;

/**
 * 发送消息
 * @author sherxia92
 */
@Data
public class InMessageDTO {
    private String content;
    private String toUser;
    private String fromUser;
}
