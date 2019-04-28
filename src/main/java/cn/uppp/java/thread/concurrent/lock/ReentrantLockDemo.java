package cn.uppp.java.thread.concurrent.lock;

import cn.uppp.java.utils.ThreadUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁
 * 保证加锁到解锁之间，所有操作的原子性
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        ThreadUtils.concurrentExecutor(new InternalThread(demo), 10);
    }

    int num = 0;
    ReentrantLock lock = new ReentrantLock();

    public void print() {
        try {
            // 获取锁
            lock.lock();
            System.out.println(++num);
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    private static class InternalThread implements Runnable {
        private ReentrantLockDemo demo;

        public InternalThread(ReentrantLockDemo demo) {
            this.demo = demo;
        }

        @Override
        public void run() {
            demo.print();
        }
    }
}
