package cn.uppp.java.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * 同步队列
 */
public class SynchronizedQueue {
    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        queue.offer(1);
    }
}
