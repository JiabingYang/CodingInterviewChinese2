package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题53（一）：数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
 * 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
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
                + k + ", " + result + "] " + (result == getNumberOfK(nums, k)));
    }

    private static int getNumberOfK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = getFirstK(nums, k);
        if (first == -1) {
            return 0;
        }
        return getLastK(nums, k) - first + 1;
    }

    private static int getFirstK(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (l < nums.length && nums[l] == k) ? l : -1;
    }

    private static int getLastK(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (r >= 0 && nums[r] == k) ? r : -1;
    }
}
