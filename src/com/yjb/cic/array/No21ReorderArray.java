package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class No21ReorderArray {

    private static void mySolution(int[] nums) {
        if (nums == null) {
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                if (i != p) {
                    int temp = nums[p];
                    nums[p] = nums[i];
                    nums[i] = temp;
                }
                p++;
            }
        }
    }

    private static void reorderOddEven(int[] nums) {
        if (nums == null) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        test(array);
        array = new int[]{2, 4, 6, 1, 3, 5, 7};
        test(array);
        array = new int[]{1, 3, 5, 7, 2, 4, 6};
        test(array);
        array = new int[]{1};
        test(array);
        array = new int[]{2};
        test(array);
        array = new int[]{};
        test(array);
        test(null);
    }

    private static void test(int[] array) {
        System.out.println("---------------------");
        System.out.println("origin: " + Arrays.toString(array));
        reorderOddEven(array);
        System.out.println("reordered: " + Arrays.toString(array));
    }
}
