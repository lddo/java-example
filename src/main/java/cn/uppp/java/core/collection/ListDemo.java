package cn.uppp.java.core.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * 演示List接口实现
 */
public class ListDemo {
    public static void main(String[] args) {
        testArrayList();

        testLinkedList();

        testVector();
    }

    /**
     * 实现原理：数组实现
     * 特点：随机访问快，插入和删除慢（每次操作都要更新，所操作元素后面的索引）
     */
    private static void testArrayList() {
        List<String> list = new ArrayList<>();
        list.add("invoke");
        list.add("execute");
        list.add("nested");
        List<String> list2 = list.stream().map(str -> str.equals("invoke") ? "调用" : "未知").collect(Collectors.toList());
        list2.forEach(System.out::println);
    }

    /**
     * 实现原理：使用内部类Node实现，每一个元素都有上一个元素
     * 特点：访问慢插入和删除快，只需要更新所操作元素的相邻元素
     */
    private static void testLinkedList() {
        List<String> list = new LinkedList<>();
        list.add("release");
        list.add("snapshot");
        list.add("current");
        list.forEach(System.out::println);
    }

    /**
     * 实现原理：
     * 特点：
     */
    private static void testVector() {
        List<String> list = new Vector<>();
        list.add("factory");
        list.add("singleton");
        list.add("observer");
        list.forEach(System.out::println);
    }

}
