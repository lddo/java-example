package cn.uppp.java.thread.pool;

import cn.uppp.java.utils.TestUtils;
import cn.uppp.java.utils.ThreadUtils;

import java.util.concurrent.*;

/**
 * 可缓存的线程池
 * 特点：该线程池的线程是弹性的，有新任务时优先使用核心线程，在核心线程全部忙碌时，会创建新的线程
 * coreSize 核心线程数
 * maxNum 最大线程数
 * keepalive 保持时间，在线程空闲时间超过改时间后，进行回收
 */
public class CachedThreadPoolDemo {
    /**
     * 预期：同时输出
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executor= Executors.newCachedThreadPool();
        executor.submit(new InternalThread());
        executor.submit(new InternalThread());
        executor.submit(new InternalThread());
    }

    private static class InternalThread implements Runnable {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ThreadUtils.outCurrentInfo();
        }
    }
}
