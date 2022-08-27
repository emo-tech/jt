package com.emo.rabbit.consumer;

import com.emo.rabbit.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author sherxia92
 */
@Slf4j
public class SpringFanoutQueue1 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        log.debug("从spring整合队列中 [{}], 监听消息: [{}]", Constant.FANOUT_QUEUE1, new String(message.getBody()));
    }
}
