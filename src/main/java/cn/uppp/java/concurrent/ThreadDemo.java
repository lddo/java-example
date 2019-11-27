package cn.uppp.java.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 继承Thread方式
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        new ThreadOne().start();
    }

    static class ThreadOne extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("当前数字：" + i);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
