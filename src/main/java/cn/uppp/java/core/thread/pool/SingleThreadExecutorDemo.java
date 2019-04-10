package cn.uppp.java.core.thread.pool;

import cn.uppp.java.core.utils.TestUtils;

import java.util.concurrent.*;

/**
 * 单线程执行器
 * 特点：该线程池中只有一个线程，在线程运行时，新加入的任务会放到阻塞队列中去
 */
public class SingleThreadExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = TestUtils.getStartTime();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> subSum = executor.submit(new InternalClass());
        Future<Integer> subSum2 = executor.submit(new InternalClass());
        Future<Integer> subSum3 = executor.submit(new InternalClass());
        Future<Integer> subSum4 = executor.submit(new InternalClass());
        Future<Integer> subSum5 = executor.submit(new InternalClass());
        // 每个任务阻塞3秒，由于采用单线程多任务，导致任务阻塞时间相加，共15秒
        System.out.println("结果：" + (subSum.get() + subSum2.get() + subSum3.get() + subSum4.get() + subSum5.get()));
        TestUtils.outExecuteTime(startTime);
    }

    private static class InternalClass implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 10000; i++) {
                sum += i;
            }
            TimeUnit.SECONDS.sleep(3);
            System.out.println("执行线程名：" + Thread.currentThread().getName());
            return sum;
        }
    }
}
