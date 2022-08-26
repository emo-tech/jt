package com.emo.rabbit.producer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author sherxia92
 */
@Slf4j
public class StockProducerTest {

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

        // 5.暂时不用交换机， 直接申明一个队列
        // 队列名称
        String queue = "stock_queue";
        // 是否持久化， 重启后不丢失
        boolean durable = true;
        // 是否独占： 只有一个消息能监听队列 ； connection关闭是是否删除队列
        boolean exclusive = false;
        boolean autoDelete = false;
        Map<String, Object> arguments = null;
        // 若果队列不存在， 会自动创建
        channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);

        // 6.发送消息
        // 交换机名称， 不设置用默认交换机
        String exchange = "";
        // 路由key， 交换机绑定到队列，routeKey和queue名一样，会自动绑定过去
        String routingKey = queue;
        AMQP.BasicProperties props = null;
        for (int i = 0; i < 100; i++) {
            String body = i +  " --- hello sher, it's my mq";
            channel.basicPublish(exchange, routingKey, props, body.getBytes());
        }

        // 7.释放资源
        channel.close();
        connection.close();
    }

}
