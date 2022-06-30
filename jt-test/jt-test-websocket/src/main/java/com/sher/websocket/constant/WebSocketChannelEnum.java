package com.sher.websocket.constant;

import org.junit.platform.commons.util.StringUtils;

/**
 * @author sherxia92
 */
public enum WebSocketChannelEnum {

    CHAT("CHAT", "测试使用的简易点对点聊天", "/topic/reply");

    private String code;

    private String description;

    private String subscriberUrl;

    WebSocketChannelEnum(String code, String description, String subscriberUrl) {
        this.code = code;
        this.description = description;
        this.subscriberUrl = subscriberUrl;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getSubscriberUrl() {
        return subscriberUrl;
    }

    public static WebSocketChannelEnum fromCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            for (WebSocketChannelEnum channelEnum : values()) {
                if (channelEnum.code.equals(code)) {
                    return channelEnum;
                }
            }
        }
        return null;
    }
}
