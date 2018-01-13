package com.yjb.cic.recursionloop;

/**
 * 面试题10：斐波那契数列
 * 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
 */
public class No10Fibonacci {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i));
        }
    }

    private static long fibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        int last = 1;
        int nextToLast = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = last + nextToLast;
            nextToLast = last;
            last = result;
        }
        return result;
    }

    /**
     * 写着玩的，用数组是没必要的
     */
    private static long fibonacciUseArray(int n) {
        if (n < 2) {
            return 1;
        }
        int[] fibs = new int[n + 1];
        fibs[0] = 1;
        fibs[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs[n];
    }
}
