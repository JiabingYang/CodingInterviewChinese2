package com.yjb.cic.array;

/**
 * 面试题57（一）：和为s的两个数字
 * 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
 * 的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 */
public class No57aTwoNumbersWithSum {

    public int[] findNumbersWithSum(int[] array, int sum) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int s = array[l] + array[r];
            if (s < sum) {
                l++;
            } else if (s > sum) {
                r--;
            } else {
                return new int[]{array[l], array[r]};
            }
        }
        return null;
    }
}
