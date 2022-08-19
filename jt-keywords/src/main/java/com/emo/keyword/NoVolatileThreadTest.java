package com.emo.keyword;

/**
 * @author sherxia92
 * 2022/8/17 0017 上午 9:58
 */
public class NoVolatileThreadTest {

    private static boolean flag = false;

    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程A开始执行:");
                for (;;){
                    if (flag){
                        System.out.println("跳出循环");
                        break;
                    }
                }
            }
        }).start();
        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B开始执行");
                flag = true;
                System.out.println("标识已经变更");
            }
        }).start();
    }

}
