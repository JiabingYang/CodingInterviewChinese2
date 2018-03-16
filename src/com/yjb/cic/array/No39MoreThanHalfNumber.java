package com.yjb.cic.array;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。
 * <p>
 * LeetCode: 169. Majority Element
 */
public class No39MoreThanHalfNumber {

    private static int checkMoreThanHalf(int[] nums) {
        int result = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
                count = 1;
            } else if (result == num) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
