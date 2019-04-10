package cn.uppp.java.core.thread.pool;

import cn.uppp.java.core.utils.TestUtils;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = TestUtils.getStartTime();
        // 生成数字
//        // 质数数量为：7714283
//        // 总耗时：135
//        long[] numbers = LongStream.rangeClosed(1, 10000000).toArray();
//        int countPrime = Arrays.stream(numbers).mapToInt(Main::isPrime).sum();
//        System.out.println("质数数量为：" + countPrime);

        // 3857138 2314286 2314286
//        long[] numbers = LongStream.rangeClosed(1, 5000000).toArray();
//        long[] numbers2 = LongStream.rangeClosed(5000001, 8000000).toArray();
//        long[] numbers3 = LongStream.rangeClosed(8000001, 10000000).toArray();
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        Future<Integer> sum = executor.submit(new InternalCallable(numbers));
//        Future<Integer> sum2 = executor.submit(new InternalCallable(numbers2));
//        Future<Integer> sum3 = executor.submit(new InternalCallable(numbers3));
//        System.out.println("质数数量为：" + (sum.get() + sum2.get() + sum3.get()));
//        executor.shutdown();

        long[] numbers = LongStream.rangeClosed(1, 5000000).toArray();
        long[] numbers2 = LongStream.rangeClosed(5000001, 8000000).toArray();
        long[] numbers3 = LongStream.rangeClosed(8000001, 10000000).toArray();
        ExecutorService executor=Executors.newWorkStealingPool(12);
        Future<Integer> sum = executor.submit(new InternalCallable(numbers));
        Future<Integer> sum2 = executor.submit(new InternalCallable(numbers2));
        Future<Integer> sum3 = executor.submit(new InternalCallable(numbers3));
        System.out.println("质数数量为：" + (sum.get() + sum2.get() + sum3.get()));
        executor.shutdown();

        TestUtils.outExecuteTime(startTime);
    }

    private static int isPrime(long num) {
        if (num < 1)
            return 0;
        for (int i = 2; i < 9; i++) {

            if (i == num)
                return 0;
            if (num % i == 0)
                return 1;
        }
        return 0;
    }

    private static class InternalCallable implements Callable<Integer> {

        private long[] nums;

        private InternalCallable(long[] nums) {
            this.nums = nums;
        }

        @Override
        public Integer call() throws Exception {
            return Arrays.stream(nums).mapToInt(Main::isPrime).sum();
        }
    }
}
