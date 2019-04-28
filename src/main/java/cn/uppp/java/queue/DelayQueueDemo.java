package cn.uppp.java.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延时队列
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        InternalClass internalClass = new InternalClass();
        DelayQueue<InternalClass> delayQueue = new DelayQueue<>();
        delayQueue.offer(internalClass);
    }

    private static class InternalClass implements Delayed {

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
