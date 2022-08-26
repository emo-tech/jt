package com.emo.rabbit.consumer;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author sherxia92
 */
@Slf4j
public class StockConsumerTest01 {

    public static void main(String[] args) throws Exception {
        // 创建 connectFactory
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("emo");
        factory.setPassword("letmein");
        factory.setVirtualHost("/emo-virtual");

        // 创建connect
        Connection connection = factory.newConnection();

        // 创建channel
        Channel channel = connection.createChannel();
        String queue = "stock_queue";
        channel.queueDeclare(queue, true, false, false, null);

        channel.basicConsume(queue, true, new DefaultConsumer(channel) {

            /**
             * 消费消息的回掉
             * @param consumerTag
             * @param envelope
             * @param properties
             * @param body
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                log.debug("consumerTag: {}", consumerTag);
//                log.debug("envelope: {}", envelope);
//                log.debug("envelope.exchange: {}", envelope.getExchange());
//                log.debug("envelope.routeKey: {}", envelope.getRoutingKey());
//                log.debug("properties: {}", properties);
                log.debug("stock01 consumer body: {}", new String(body));
            }
        });
    }
}
