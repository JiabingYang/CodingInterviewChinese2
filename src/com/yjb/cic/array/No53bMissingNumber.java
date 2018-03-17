package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题53（二）：0到n-1中缺失的数字
 * 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
 * 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
 * 中，请找出这个数字。
 */
public class No53bMissingNumber {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5}, 0);// 缺失的是第一个数字0
        test(new int[]{0, 1, 2, 3, 4}, 5);// 缺失的是最后一个数字
        test(new int[]{0, 1, 2, 4, 5}, 3);// 缺失的是中间某个数字
        test(new int[]{1}, 0);// 数组中只有一个数字，缺失的是第一个数字0
        test(new int[]{0}, 1);// 数组中只有一个数字，缺失的是最后一个数字1
        test(new int[]{}, 0);// 空数组
        test(null, -1);// null
    }

    private static void test(int[] data, int result) {
        System.out.println("[" + Arrays.toString(data) + ", " + result + "] " + (result == mySolution(data)));
    }

    private static int mySolution(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }
}
