package cn.uppp.java.concurrent.pool;

import cn.uppp.java.utils.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 固定线程池
 * 特点：在线程池创建时，指定线程数量后，不可更改
 */
public class FixedThreadPoolDemo {
    /**
     * 初始化线程为2个，任务为三个
     * 预期：第三个任务耗时比其他任务多1秒
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new InternalThread());
        executor.submit(new InternalThread());
        executor.submit(new InternalThread());
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
