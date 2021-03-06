package com.yjb.cic.array;

/**
 * 面试题53（三）：数组中数值和下标相等的元素
 * 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
 * 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
 * 1, 3, 5}中，数字3和它的下标相等。
 */
public class No53cIntegerIdenticalToIndex {

    private static int getNumberSameAsIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > mid) {
                r = mid - 1;
            } else if (nums[mid] < mid) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
