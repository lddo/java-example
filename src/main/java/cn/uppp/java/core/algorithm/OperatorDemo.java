package cn.uppp.java.core.algorithm;

/**
 * 移位运算
 */
public class OperatorDemo {
    public static void main(String[] args) {
        // 左移运算符（乘）
        int num = 10 << 2;
        System.out.println("结果：" + num);

        // 右移运算符
        int num2 = 10 >> 2;
        System.out.println("结果：" + num2);

        // 无符号右移运算符
        int num3 = 10 >>> 2;
        System.out.println("结果：" + num3);

        // 按位与运算符
        int num5 = 10 & 2;
        System.out.println("结果：" + num5);

        // 按位或运算符
        int num6 = 10 | 3;
        System.out.println("结果：" + num6);

        // 异或运算符(相同则为0)
        int num4 = 10 ^ 3;
        System.out.println("结果：" + num4);

        // 取反运算符
        int num7 = ~10;
        System.out.println("结果：" + num7);
    }
}
