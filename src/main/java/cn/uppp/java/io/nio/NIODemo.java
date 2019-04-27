package cn.uppp.java.io.nio;

/**
 * 同步非阻塞（Non Blocking IO）
 */
public class NIODemo {
    public static void main(String[] args) {
        testNIODemo(1);
    }

    private static void testNIODemo(int i) {
        i++;
        if (i == 10)
            return;
        testNIODemo(i);
        System.out.println(i);
    }
}
