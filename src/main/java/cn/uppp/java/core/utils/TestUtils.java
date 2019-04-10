package cn.uppp.java.core.utils;

import java.util.Arrays;

public class TestUtils {
    /**
     * 获取现在时间
     * @return
     */
    public static long getStartTime() {
        return System.currentTimeMillis();
    }

    /**
     * 输出执行时间
     * @param startTime
     */
    public static void outExecuteTime(long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }

    public static void outResult(Object[] objs){
        Arrays.stream(objs).forEach(System.out::println);
        System.out.println("-----------------------------------");
    }
}
