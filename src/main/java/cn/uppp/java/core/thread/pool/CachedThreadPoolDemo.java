package cn.uppp.java.core.thread.pool;

import cn.uppp.java.core.utils.TestUtils;

import java.util.concurrent.*;

/**
 * 可缓存的线程池
 * 特点：该线程池的线程是弹性的，有新任务时优先使用核心线程，在核心线程全部忙碌时，会创建新的线程
 * coreSize 核心线程数
 * maxNum 最大线程数
 * keepalive 保持时间，在线程空闲时间超过改时间后，进行回收
 */
public class CachedThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = TestUtils.getStartTime();
        // 创建可缓存线程池对象
        ExecutorService executor= Executors.newCachedThreadPool();
        // 将计算任务加入线程池
        Future<Integer> subSum = executor.submit(new InternalCallable());
        Future<Integer> subSum2 = executor.submit(new InternalCallable());
        Future<Integer> subSum3 = executor.submit(new InternalCallable());
        Future<Integer> subSum4 = executor.submit(new InternalCallable());
        Future<Integer> subSum5 = executor.submit(new InternalCallable());
        // 将任务结果汇总
        System.out.println(subSum.get() + subSum2.get() + subSum3.get() + subSum4.get() + subSum5.get());
        // 每个任务阻塞三秒，由于同时处理，总共阻塞共三秒
        TestUtils.outExecuteTime(startTime);
    }

    private static class InternalCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
            TimeUnit.SECONDS.sleep(3);
            System.out.println("执行线程名："+Thread.currentThread().getName());
            return sum;
        }
    }
}
