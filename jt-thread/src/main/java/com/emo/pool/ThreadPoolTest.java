package com.emo.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sherxia92
 */
@Slf4j
public class ThreadPoolTest {

    public static void main(String[] args) throws NoSuchFieldException {
        createThreadPool();
    }

    public static void createThreadPool()  {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                3,
                0,
                TimeUnit.MILLISECONDS,
                queue,
                r -> new Thread(r, "myThread" + atomicInteger.getAndIncrement()),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        long delay = 10000;
        showState(queue, threadPoolExecutor);
        threadPoolExecutor.submit(new MyTask("1", delay));
        showState(queue, threadPoolExecutor);
        threadPoolExecutor.submit(new MyTask("2", delay));
        showState(queue, threadPoolExecutor);
        threadPoolExecutor.submit(new MyTask("3"));
        showState(queue, threadPoolExecutor);
        threadPoolExecutor.submit(new MyTask("4"));
        showState(queue, threadPoolExecutor);
        threadPoolExecutor.submit(new MyTask("5", delay));
        showState(queue, threadPoolExecutor);
        threadPoolExecutor.submit(new MyTask("6"));
        showState(queue, threadPoolExecutor);
    }

    private static void showState(ArrayBlockingQueue<Runnable> queue, ThreadPoolExecutor threadPoolExecutor) {
        try {
            Thread.sleep(1000);
            Field filed = threadPoolExecutor.getClass().getDeclaredField("workers");
            filed.getName();
//        log.debug("queue: [{}],  size: [{}], threadPoolExecutor: [{}], task: [{}],", queue, queue.size(), threadPoolExecutor, threadPoolExecutor.getTaskCount());
//        log.debug("threadPoolExecutor: [{}]",  threadPoolExecutor);
//        log.debug("[{}]",  threadPoolExecutor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Slf4j
    static class MyTask implements Runnable {
        private String name;
        private long duration;

        MyTask(String name) {
            this(name, 0);
        }

        MyTask(String name, long duration) {
            this.name = name;
            this.duration = duration;
        }

        @SneakyThrows
        @Override
        public void run() {
            log.debug("thread: [{}] is running", name);
            Thread.sleep(duration);
        }
    }
}
