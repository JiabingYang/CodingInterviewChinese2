package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题51：数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
 * 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class No51InversePairs {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 7, 6, 5}, 3);
        test(new int[]{6, 5, 4, 3, 2, 1}, 15);
        test(new int[]{1, 2, 3, 4, 5, 6}, 0);
        test(new int[]{1}, 0);
        test(new int[]{1, 2}, 0);
        test(new int[]{2, 1}, 1);
        test(new int[]{1, 2, 1, 2, 1}, 3);
        test(null, 0);
    }

    private static void test(int[] data, int result) {
        System.out.println("[" + Arrays.toString(data) + ", " + result + "] " + (result == mySolution(data)));
    }

    /**
     * 参考自：
     * http://blog.csdn.net/derrantcm/article/details/46761051
     * <p>
     * 归并排序写法按照《数据结构与算法分析》中的写法
     */
    private static int mySolution(int[] data) {
        if (data == null || data.length < 2) {
            return 0;
        }

        return mySolutionCore(data, new int[data.length], 0, data.length - 1);
    }

    private static int mySolutionCore(int[] data, int[] arr, int ls, int re) {
        if (ls == re) {
            return 0;
        }

        int le = ls + (re - ls) / 2;
        int rs = le + 1;
        int n = re - ls + 1;

        int lCount = mySolutionCore(data, arr, ls, le);
        int rCount = mySolutionCore(data, arr, rs, re);

        int p = re;
        int count = 0;

        while (ls <= le && rs <= re) {
            if (data[le] > data[re]) {
                arr[p--] = data[le--];
                count += re - rs + 1; // le > re时，增加逆序数
            } else {
                arr[p--] = data[re--];
            }
        }

        while (ls <= le) {
            arr[p--] = data[le--];
        }
        while (rs <= re) {
            arr[p--] = data[re--];
        }

        for (int i = 0; i < n; i++, ls++) {
            data[ls] = arr[ls];
        }

        return count + lCount + rCount;
    }
}
