package cn.uppp.java.concurrent.temp;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ldd
 * @date 2019/11/27
 */
public class ShareLockDemo {
    public static void main(String[] args) {
        Test hello = new Test();

        // 多个线程公用一把锁，等待每一个线程：加锁 -> 执行 -> 释放锁
        new Thread(hello::sayName).start();
        new Thread(hello::sayAge).start();
    }

    static class Test {
        private ReentrantLock lock = new ReentrantLock(true);

        public void sayName() {
            try {
                lock.lock();
                System.out.println("My name is Tom");
            } finally {
                lock.unlock();
            }
        }

        public void sayAge() {
            try {
                lock.lock();
                System.out.println("My age is 18");
            } finally {
                lock.unlock();
            }
        }
    }
}
