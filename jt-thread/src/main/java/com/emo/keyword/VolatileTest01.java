package com.emo.keyword;

/**
 * @author sherxia92
 * 2022/8/17 0017 上午 9:58
 * @description： volatile 关键字多线程可见性
 */
public class VolatileTest01 {

    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {

//            System.out.println("thread is finished");

            System.out.println("线程A开始执行:");

            int times = 0;
//            while (!flag) {
//
//            }

            for (;;){
//                System.out.println("thread is running and times is " + (++times));
//                System.out.println("thread is running");
                if (flag){
                    System.out.println("跳出循环");
                    break;
                }
            }
            System.out.println("线程A执行结束");
        }).start();

        Thread.sleep(10);

        new Thread(() -> {
            System.out.println("B thread is running");
            flag = true;
            System.out.println("B thread update flag true");
        }).start();
    }
}
