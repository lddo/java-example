package cn.uppp.java.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 实现Callable接口方式，返回值为Future
 */
public class CallableFutureDemo {

    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new TestCallable();
        // 获取结果，在结果返回之前会进行阻塞
        Integer call = callable.call();
        System.out.println(call);
    }

    public static class TestCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            TimeUnit.SECONDS.sleep(3);
            System.out.println("0-100的和：" + sum);
            return sum;
        }
    }
}
