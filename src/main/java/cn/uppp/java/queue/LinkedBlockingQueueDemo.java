package cn.uppp.java.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 链表结构的阻塞队列
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.offer(1);
    }
}
