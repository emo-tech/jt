package com.sher.rabbit.work;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-16 17:23
 */
@Slf4j
@RabbitListener(queues = "work.hello")
public class WorkReceiver {

    private final int instance;

    public WorkReceiver(int i) {
        this.instance = i;
    }

    @RabbitHandler
    public void receive(String in) {
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance {} [X] Received '{}'", this.instance, in);
        doWork(in);
        watch.stop();
        log.info("instance {} [X] Done in {}s", this.instance, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) {
        for (char ch: in.toCharArray()) {
            if (ch== '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }
}
