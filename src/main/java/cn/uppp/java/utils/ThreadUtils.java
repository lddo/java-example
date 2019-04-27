package cn.uppp.java.utils;

/**
 * 线程工具类
 */
public class ThreadUtils {

    /**
     * 并发执行器
     *
     * @param runnable
     * @param threadNum
     */
    public static void concurrentExecutor(Runnable runnable, int threadNum) {
        for (int i = 0; i < threadNum; i++) {
            new Thread(runnable).start();
        }
    }
}
