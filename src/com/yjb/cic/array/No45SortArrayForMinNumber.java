package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题45：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
 * 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
 * 字能排成的最小数字321323。
 * <p>
 * 相似题目：
 * Leetcode: 179. Largest Number
 */
public class No45SortArrayForMinNumber {

    private static String printMinNumber(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }

        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
