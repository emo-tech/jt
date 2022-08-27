package com.emo.rabbit.consumer;

import com.emo.rabbit.constant.Constant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

/**
 * @author sherxia92
 */
@Slf4j
public class SpringAckFanoutQueue2 implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(1000);
        log.debug("从spring整合队列中 [{}], 监听消息: [{}]", Constant.FANOUT_QUEUE2, new String(message.getBody()));
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
//            int i =1/0;
            channel.basicAck(deliveryTag, true);
            log.debug("消费完成");
        } catch (Exception e) {
            channel.basicNack(deliveryTag, true, true);
            log.debug("消费报错");
        }
    }
}
