package cn.uppp.java.core.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 演示Map接口实现
 */
public class MapDemo {
    public static void main(String[] args) {
        testHashMap();

        testConcurrentMap();

        testHashTable();

        testTreeMap();

        testLinkedHashMap();
    }

    /**
     * 实现原理：主体是一个Entry数组，包含了key的hash值、key、value、、
     * 特点：
     */
    private static void testHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("start", "开始");
        map.put("pause", "暂停");
        map.put("interrupt", "中断");
        map.forEach((key, value) -> System.out.println("HashMap -> Key：" + key + "  Value：" + value));
    }

    /**
     * 实现原理：
     * 特点：
     */
    private static void testConcurrentMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("gte", "大于等于");
        map.put("lte", "小于等于");
        map.put("eq", "等于");
        map.forEach((key, value) -> System.out.println("ConcurrentMap -> Key：" + key + "  Value：" + value));
    }

    /**
     * 实现原理：
     * 特点：
     */
    private static void testHashTable() {
        Map<String, String> map = new Hashtable<>();
        map.put("preview", "预览");
        map.put("introduction", "介绍");
        map.put("preface", "前言");
        map.forEach((key, value) -> System.out.println("HashTable -> Key：" + key + "  Value：" + value));
    }

    /**
     *
     */
    private static void testTreeMap() {
        Map<String, String> map = new TreeMap<>();
        map.put("reflect", "反射");
        map.put("annotation", "注解");
        map.put("concurrent", "并发");
        map.forEach((key, value) -> System.out.println("TreeMap -> Key：" + key + " Value：" + value));
    }

    /**
     * 实现原理：基于链表实现的HashMap,保证遍历的有序性
     */
    private static void testLinkedHashMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("lookup", "查找");
        map.put("diagram", "图标");
        map.put("clone", "克隆");
        map.forEach((key, value) -> System.out.println("LinkedHashMap -> Key：" + key + " Value：" + value));
    }
}
