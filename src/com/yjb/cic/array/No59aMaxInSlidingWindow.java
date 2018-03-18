package com.yjb.cic.array;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 面试题59（一）：滑动窗口的最大值
 * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
 * 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
 * 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}。
 * <p>
 * Leetcode: 239. Sliding Window Maximum
 */
public class No59aMaxInSlidingWindow {

    /**
     * 20ms
     * <p>
     * https://www.programcreek.com/2014/05/leetcode-sliding-window-maximum-java/
     * <p>
     * <img src=https://www.programcreek.com/wp-content/uploads/2014/05/sliding-window-maximum.png>
     * <p>
     * 时间 n 空间 k
     */
    private static int[] solution1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k) { // 删除已经移除窗口的头
                deque.poll();
            }
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] <= num) { // 保证队列中前面的比后面的大
                deque.removeLast();
            }
            deque.offer(i);
            if (i + 1 >= k) {
                result[i - k + 1] = nums[deque.peek()]; // 队列头部一定是最大的
            }
        }
        return result;
    }

    /**
     * From a leetcode user.
     * <p>
     * 68ms
     * <p>
     * 用堆来保证拿到最大值，
     * 在滑动窗口时，先把移出窗口的值在堆中删掉
     * <p>
     * 时间 nlogk 空间 k
     * <p>
     * 这个方法是我想到的方法
     */
    private static int[] solution2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 把窗口最左边的数去掉
            if (i >= k) {
                pq.remove(nums[i - k]);
            }
            // 把新的数加入窗口的堆中
            pq.offer(nums[i]);
            // 堆顶就是窗口的最大值
            if (i + 1 >= k) {
                res[i - k + 1] = pq.peek();
            }
        }
        return res;
    }

    /**
     * From a leetcode user.
     * <p>
     * 3ms
     * <p>
     * 时间 n*k 空间 1
     * <p>
     * 这个方法是我想到的方法
     */
    private static int[] solution3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = k - 1;
        int max = -1;
        while (right < nums.length) {
            if (max < left) {
                max = left;
                // 每当max过期过后重新，重新寻找nums[left~right]的最大者。
                // 在最坏情况下（nums降序排列），复杂度是n*k
                for (int i = left + 1; i <= right; i++) {
                    if (nums[i] >= nums[max]) {
                        max = i;
                    }
                }
            } else if (nums[right] >= nums[max]) {
                max = right;
            }
            result[left] = nums[max];
            left++;
            right++;
        }
        return result;
    }
}
