package cn.uppp.java.thread.concurrent;

import cn.uppp.java.utils.ThreadUtils;

import java.util.concurrent.Semaphore;

/**
 * 只会对线程数进行监控，并不能保证线程安全
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        ThreadUtils.concurrentExecutor(new InternalThread(new SemaphoreDemo()), 10);
    }

    int num = 0;

    private void print() {
        Semaphore semaphore = new Semaphore(1);
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "  " + System.currentTimeMillis() +"  "+ (++num));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private static class InternalThread implements Runnable {
        private SemaphoreDemo demo;

        public InternalThread(SemaphoreDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            demo.print();
        }
    }
}
