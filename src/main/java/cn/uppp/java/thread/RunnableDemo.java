package cn.uppp.java.thread;

import java.util.concurrent.TimeUnit;

/**
 * 实现Runnable接口方式
 */
public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new RunnableOne()).start();
    }

    static class RunnableOne implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Demo线程。。。");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
