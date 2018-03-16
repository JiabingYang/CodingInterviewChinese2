package com.yjb.cic.array;

/**
 * 面试题42：连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
 * 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 */
public class No42GreatestSumOfSubarrays {

    private static int findGreatestSumOfSubArray1(int[] nums) {
        if (nums.length == 0)
            throw new RuntimeException("the length of the array can't be 0.");
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            if (sum > max) {
                max = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    private static int findGreatestSumOfSubArray2(int[] nums) {
        if (nums.length == 0)
            throw new RuntimeException("the length of the array can't be 0.");
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
