package com.yjb.cic.array;

/**
 * 面试题11：旋转数组的最小数字
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
 * {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 *
 * LeetCode: 154. Find Minimum in Rotated Sorted Array II
 */
public class No11MinNumberInRotatedArray {

    /**
     * 如果mid和end相等只需要end左移一位
     * 或者：start和end相等，start右移一位或者end左移一位
     */
    private static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) { // 最大值 -> mid -> end  || 未旋转的数组 <=> nums[mid] <= nums[end]
                end = mid;
            } else if (nums[mid] > nums[end]) { // mid -> 最大值 -> end <=> nums[mid] > nums[end]
                start = mid + 1;
            } else {
                end--;
            }
        }
        return nums[end];
    }
}
