package cn.uppp.java.thread.concurrent.lock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        final String java = "java";
        final String python = "python";
        new Thread(()->{
            while(true) {
                synchronized (java) {
                    System.out.println("before java");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (python) {
                        System.out.println("after python");
                    }
                }
            }
        }).start();

        new Thread(()->{
            while(true){
                synchronized (python){
                    System.out.println("before python");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (java){
                        System.out.println("after java");
                    }
                }
            }
        }).start();
    }
}
