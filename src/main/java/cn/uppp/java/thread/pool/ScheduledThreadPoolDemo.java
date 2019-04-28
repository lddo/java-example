package cn.uppp.java.thread.pool;

import cn.uppp.java.utils.ThreadUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 计划线程池
 * 可延期执行任务的线程池
 * deploy：延期执行时间
 * unit：时间单位
 */
public class ScheduledThreadPoolDemo {
    /**
     * 可眼
     * @param args
     */
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.schedule(new InternalThread(), 1, TimeUnit.SECONDS);
        executor.schedule(new InternalThread(), 2, TimeUnit.SECONDS);
        executor.schedule(new InternalThread(), 3, TimeUnit.SECONDS);
        executor.shutdown();
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
