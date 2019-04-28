package cn.uppp.java.thread.concurrent;

import cn.uppp.java.utils.ThreadUtils;

/**
 * synchronized
 * 特性：原子性、可见性
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        ThreadUtils.concurrentExecutor(new InternalThread(new SynchronizedDemo()), 10);
    }

    int num = 0;
    public synchronized void print(){
        System.out.println(++num);
    }

    private static class InternalThread implements Runnable{
        private SynchronizedDemo demo;

        public InternalThread(SynchronizedDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            demo.print();
        }
    }
}
