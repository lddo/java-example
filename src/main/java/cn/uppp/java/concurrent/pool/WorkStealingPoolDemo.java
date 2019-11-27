package cn.uppp.java.concurrent.pool;

import cn.uppp.java.utils.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 工作窃取线程池
 */
public class WorkStealingPoolDemo {
    /**
     * 预期：
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool(2);
        executor.submit(new InternalThread());
        executor.submit(new InternalThread());
        executor.submit(new InternalThread());
        executor.shutdown();
        // 必须阻塞，否则看不到结果
        while (true) {
            TimeUnit.HOURS.sleep(1);
        }
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
