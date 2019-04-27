package cn.uppp.java.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 计划线程池
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newScheduledThreadPool(3);
    }
}
