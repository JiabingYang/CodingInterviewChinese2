package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题66：构建乘积数组
 * 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
 * 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class No66ConstuctArray {

    /**
     * https://github.com/CyC2018/Interview-Notebook/blob/master/notes/剑指%20offer%20题解.md
     * <p>
     * 时间n 空间1
     */
    private static int[] multiply(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0, product = 1; i < n; product *= a[i], i++) {
            b[i] = product;
        }
        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--) {
            b[i] *= product;
        }
        return b;
    }

    /**
     * 时间n2 空间n2
     */
    private static int[] mySolution(int[] a) {
        if (a == null || a.length <= 1) {
            return null;
        }
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = a[i];
        }
        for (int diff = 1; diff <= n - 2; diff++) {
            for (int i = 0; i < n - diff; i++) {
                dp[i][i + diff] = dp[i][i + diff - 1] * a[i + diff];
            }
        }
        int[] b = new int[n];
        b[0] = dp[1][n - 1];
        b[n - 1] = dp[0][n - 2];
        for (int i = 1; i < n - 1; i++) {
            b[i] = dp[0][i - 1] * dp[i + 1][n - 1];
        }
        return b;
    }

    /* ---------------- test -------------- */

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5}, new int[]{120, 60, 40, 30, 24});
        test(new int[]{1, 2, 0, 4, 5}, new int[]{0, 0, 40, 0, 0});
        test(new int[]{1, 2, 0, 4, 0}, new int[]{0, 0, 0, 0, 0});
        test(new int[]{1, -2, 3, -4, 5}, new int[]{120, -60, 40, -30, 24});
        test(new int[]{1, -2}, new int[]{-2, 1});
    }

    private static void test(int[] a, int[] b) {
        System.out.println("-----------------------------");
        System.out.println("a = " + Arrays.toString(a) + ", b = " + Arrays.toString(b));
        System.out.println(Arrays.equals(mySolution(a), b) ? "passed" : "failed");
    }
}
