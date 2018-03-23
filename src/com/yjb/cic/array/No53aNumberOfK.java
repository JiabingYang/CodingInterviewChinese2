package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题53（一）：数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
 * 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 * <p>
 * Leetcode: 34. Search for a Range
 */
public class No53aNumberOfK {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3, 4);
        test(new int[]{3, 3, 3, 3, 4, 5}, 3, 4);
        test(new int[]{1, 2, 3, 3, 3, 3}, 3, 4);
        test(new int[]{1, 3, 3, 3, 3, 4, 5}, 2, 0);
        test(new int[]{1, 3, 3, 3, 3, 4, 5}, 0, 0);
        test(new int[]{1, 3, 3, 3, 3, 4, 5}, 6, 0);
        test(new int[]{3, 3, 3, 3}, 3, 4);
        test(new int[]{3, 3, 3, 3}, 4, 0);
        test(new int[]{3}, 3, 1);
        test(new int[]{3}, 4, 0);
        test(null, 0, 0);
    }

    private static void test(int[] nums, int k, int result) {
        System.out.println("[" + Arrays.toString(nums) + ", "
                + k + ", " + result + "] " + (result == mySolution(nums, k)));
    }

    /**
     * 对书本上写法做了优化
     */
    private static int mySolution(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = findLeft(nums, k, 0, nums.length - 1);
        if (left == -1) {
            return 0;
        }
        return findRight(nums, k, left, nums.length - 1) - left + 1;
    }

    private static int findLeft(int[] nums, int target, int l, int r) {
        int temp = r;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (l <= temp && nums[l] == target) ? l : -1;
    }

    private static int findRight(int[] nums, int target, int l, int r) {
        int temp = l;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (r >= temp && nums[r] == target) ? r : -1;
    }
}
