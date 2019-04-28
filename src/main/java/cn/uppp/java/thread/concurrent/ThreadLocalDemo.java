package cn.uppp.java.thread.concurrent;

import cn.uppp.java.utils.ThreadUtils;

/**
 * ThreadLocal例子
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        demo.amount.set(0);

        PlusThread plusThread = new PlusThread(demo);
        MinusThread minusThread = new MinusThread(demo);

        ThreadUtils.concurrentExecutor(plusThread, 5);
        ThreadUtils.concurrentExecutor(minusThread, 5);

        System.out.println("计算后金额：" + demo.amount.get());
    }

    ThreadLocal<Integer> amount = new ThreadLocal<>();

    public synchronized void plus() {
        amount.set(amount.get() + 1);
    }

    public synchronized void minus() {
        amount.set(amount.get() - 1);
    }

    /**
     * 减
     */
    private static class PlusThread implements Runnable {
        private ThreadLocalDemo demo;

        public PlusThread(ThreadLocalDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            demo.plus();
        }
    }

    /**
     * 加
     */
    private static class MinusThread implements Runnable {
        private ThreadLocalDemo demo;

        public MinusThread(ThreadLocalDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            demo.minus();
        }
    }
}
