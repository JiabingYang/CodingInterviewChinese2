package com.yjb.cic.array;

import java.util.*;

/**
 * 面试题40：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 */
public class No40KLeastNumbers {

    public static void main(String[] args) {
        test(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4, new int[]{1, 2, 3, 4}); // k小于数组的长度
        test(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 8, new int[]{1, 2, 3, 4, 5, 6, 7, 8}); // k等于数组的长度
        test(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 9, new int[]{}); // k大于数组的长度
        test(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 1, new int[]{1}); // k等于1
        test(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 0, new int[]{}); // k等于0
        test(new int[]{4, 5, 1, 6, 2, 7, 2, 8}, 2, new int[]{1, 2}); // 数组中有相同的数字
    }

    private static void test(int[] input, int k, int[] result) {
        System.out.println("-----------------------------------");
        System.out.println("result: " + Arrays.toString(result));
        List<Integer> result1 = getLeastNumbers1(input, k);
        Collections.sort(result1);
        System.out.println("1:      " + result1);
        List<Integer> result2 = getLeastNumbers2(input, k);
        Collections.sort(result2);
        System.out.println("2:      " + result2);
    }

    /**
     * 基于最大堆
     */
    private static List<Integer> getLeastNumbers1(int[] input, int k) {
        if (k > input.length || k <= 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : input) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    /**
     * 基于快速选择
     */
    private static List<Integer> getLeastNumbers2(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k <= 0) {
            return result;
        }
        int num = quickSelect(input, k, 0, input.length - 1);
        for (int n : input) {
            if (n <= num && result.size() < k) {
                result.add(n);
            }
        }
        return result;
    }

    private static int quickSelect(int[] input, int k, int l, int r) {
        int pivotIndex = getPivotIndex(input, l, r);
        if (k == pivotIndex + 1) {
            return input[pivotIndex];
        }
        if (k < pivotIndex + 1) {
            return quickSelect(input, k, l, pivotIndex - 1);
        }
        return quickSelect(input, k, pivotIndex + 1, r);
    }

    private static int getPivotIndex(int[] input, int l, int r) {
        int pivot = input[l];
        while (l < r) {
            while (l < r && input[r] >= pivot) {
                r--;
            }
            input[l] = input[r];
            while (l < r && input[l] <= pivot) {
                l++;
            }
            input[r] = input[l];
        }
        input[l] = pivot;
        return l;
    }
}
