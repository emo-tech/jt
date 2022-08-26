package com.emo.rabbit.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 */
@Slf4j
public class ProducerTest_Direct {

    public static void main(String[] args) throws Exception {
        // 1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        // 2.设置参数
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("emo");
        factory.setPassword("letmein");
        factory.setVirtualHost("/emo-virtual");

        // 3.创建连接
        Connection connection = factory.newConnection();

        // 4.创建channel， channel是connection里的一个通信通道
        Channel channel = connection.createChannel();

        // 5.创建交换机
        String exchange = "exchange_direct";
        BuiltinExchangeType type =  BuiltinExchangeType.DIRECT;
        channel.exchangeDeclare(exchange, type, true);

        // 6.创建队列
        String queue1 = "queue_direct_1";
        String queue2 = "queue_direct_2";

        String routeKey1 = "route_direct_1";
        String routeKey2 = "route_direct_2";

        // 若果队列不存在， 会自动创建
        channel.queueDeclare(queue1, true, false, false, null);
        channel.queueDeclare(queue2, true, false, false, null);

        // 7.队列保定交换机
        channel.queueBind(queue1, exchange, routeKey1);
        channel.queueBind(queue2, exchange, routeKey2);


        // 8.发送消息
        for (int i = 0; i< 10; i++) {
            String body = i + "-- this is a message from direct";
            channel.basicPublish(exchange, i%2==1 ? routeKey1 : routeKey2, null, body.getBytes());
        }

        // 9.释放资源
        channel.close();
        connection.close();
    }

}
