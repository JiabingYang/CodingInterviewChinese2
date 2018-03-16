package com.yjb.cic.heap;

import java.util.PriorityQueue;

/**
 * 面试题41：数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
 * 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class No41StreamMedian {

    private static class Solution {
        // 最大堆，存储左半边元素
        private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 最小堆，存储右半边元素，并且右半边元素都大于左半边
        private PriorityQueue<Integer> right = new PriorityQueue<>();
        // 当前数据流读入的元素个数
        private int n = 0;

        public void insert(Integer num) {
            if (n % 2 == 0) {
                left.add(num);
                right.add(left.poll());
            } else {
                right.add(num);
                left.add(right.poll());
            }
            n++;
        }

        public double getMedian() {
            if (n % 2 == 0) {
                return (left.peek() + right.peek()) / 2.0;
            } else {
                return (double) right.peek();
            }
        }
    }
}
