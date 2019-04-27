package cn.uppp.java.algorithm;

/**
 * 查找
 */
public class SearchDemo {
    public static void main(String[] args) {
        // 一个有序的数组
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 二分查找
        System.out.println(testBinarySearch(nums, 10));
    }

    /**
     * 在有序数组内查找key，找到返回下标，不存在返回 -1
     *
     * @param nums
     * @param key
     * @return
     */
    private static int testBinarySearch(int[] nums, int key) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (key < nums[mid]) right = mid - 1;
            else if (key > nums[mid]) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
