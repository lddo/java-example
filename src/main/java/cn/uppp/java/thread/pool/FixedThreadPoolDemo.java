package cn.uppp.java.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程池
 * 特点：在线程池创建时，指定线程数量后，不可更改
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(3);
    }
}
