package cn.uppp.java.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 数组结构的阻塞队列
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1024);
        blockingQueue.offer(1);
    }
}
