package com.sher.rabbit.work;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * @description:
 * @author: sher xia
 * @create: 2021-11-17 10:52
 */
@Slf4j
public class DirectReceiver {

    @RabbitListener(queues = "#{directQueue1.name}")
    public void receive1(String in) {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{directQueue2.name}")
    public void receiver2(String in) {
        receive(in, 2);
    }

    private void receive(String in, int receiver) {
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance {} [X] Received '{}'", receiver, in);
        doWork(in);
        watch.stop();
        log.info("instance {} [X] Done in {}s", receiver, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }
}
