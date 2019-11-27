package cn.uppp.java.concurrent.pool;

import cn.uppp.java.utils.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 单线程执行器
 * 特点：该线程池中只有一个线程，在该线程运行时，其他任务会放到LinkedBlockingQueue阻塞队列中，保证执行顺序
 */
public class SingleThreadExecutorDemo {
    /**
     * 预期：一个一个输出，间隔一秒
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
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
