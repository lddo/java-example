package cn.uppp.java.core.algorithm;

import java.util.Arrays;

/**
 * 八大排序算法
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

//        testBubbleSort(nums);
        testQuickSort(nums, 0, nums.length - 1);
    }

    /**
     * 名称：冒泡排序
     * 时间复杂度：O(n²)
     * 特性：稳定
     * 原理：把大（小）元素向后（前）移动
     */
    private static void testBubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        Arrays.stream(nums).forEach(num -> System.out.print(num + "  "));
    }

    /**
     * 名称：快速排序
     * 时间复杂度：
     * 特性：
     * 原理：
     */
    private static void testQuickSort(int[] nums, int left, int right) {
        // 校验
        if (right <= left) return;
        // 切分
        int j = partition(nums, left, right);
        // 递归排序左半部
        testQuickSort(nums, left, j - 1);
        testQuickSort(nums, j + 1, right);
        Arrays.stream(nums).forEach(num -> System.out.print(num + "  "));
        System.out.println();
    }
    // 切分
    private static int partition(int[] nums, int left, int right) {
        // 找到需要交换元素的下标
        int i = left, j = right + 1;
        // 切分元素
        int num = nums[left];
        while (true) {
            while (num < nums[--j]) if (j == left) break;
            while (num > nums[++i]) if (i == right) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    // 交换元素
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 名称：插入排序
     * 时间复杂度：
     * 特性：
     * 原理：
     */
    private static void testInsertionSort() {

    }

    /**
     * 名称：选择排序
     * 时间复杂度：
     * 特性：
     * 原理：
     */
    private static void testSelectionSort() {

    }

    /**
     * 名称：希尔排序
     * 时间复杂度：
     * 特性：
     * 原理：
     */
    private static void testQuickSort2() {

    }

    /**
     * 名称：堆排序
     * 时间复杂度：
     * 特性：
     * 原理：
     */
    private static void testQuickSort3() {

    }

    /**
     * 名称：归并排序
     * 时间复杂度：
     * 特性：
     * 原理：
     */
    private static void testQuickSort4() {

    }

    /**
     * 名称：桶式排序
     * 时间复杂度：
     * 特性：
     * 原理：
     */
    private static void testQuickSort5() {

    }

}
