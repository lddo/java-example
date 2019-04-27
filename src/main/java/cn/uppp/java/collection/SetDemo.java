package cn.uppp.java.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 演示Set接口实现
 */
public class SetDemo {
    public static void main(String[] args) {
        testHashSet();
//        testTreeSet();
//        testLinkedHashSet();
    }

    /**
     * 实现原理：
     * 特点：
     */
    private static void testHashSet() {
        Set<String> set = new HashSet<>();
        set.add("tom");
        set.add("tony");
        set.add("jerry");
        set.forEach(System.out::println);
    }

    /**
     * 实现原理：
     * 特点：
     */
    private static void testTreeSet() {
        Set<String> set = new TreeSet<>();
        set.add("tom");
        set.add("tony");
        set.add("jerry");
        set.forEach(System.out::println);
    }

    /**
     * 实现原理：
     * 特点：
     */
    private static void testLinkedHashSet() {
        Set<String> set = new LinkedHashSet<>();
        set.add("tom");
        set.add("tony");
        set.add("jerry");
        set.forEach(System.out::println);
    }
}
