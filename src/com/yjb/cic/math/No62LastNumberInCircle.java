package com.yjb.cic.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题62：圆圈中最后剩下的数字
 * 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
public class No62LastNumberInCircle {

    /**
     * 按照书上方法1的思路自己写的
     */
    private static int lastRemaining1(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            nums.add(i);
        }

        int p = 0;
        while (nums.size() > 1) {
            p = (p + m - 1) % nums.size();
            nums.remove(p);
        }
        return nums.get(0);
    }

    /**
     * https://github.com/CyC2018/Interview-Notebook/blob/master/notes/剑指%20offer%20题解.md
     */
    private static int lastRemaining2(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (lastRemaining2(n - 1, m) + m) % n;
    }

    /* ---------------- test -------------- */

    public static void main(String[] args) {
        test(5, 3, 3);
        test(5, 2, 2);
        test(6, 7, 4);
        test(6, 6, 3);
        test(0, 0, -1);
        test(4000, 997, 1027);
    }

    private static void test(int n, int m, int result) {
        System.out.println("--------------------------");
        System.out.println("n = [" + n + "], m = [" + m + "], result = [" + result + "]");
        if (lastRemaining1(n, m) != result) {
            System.out.println("lastRemaining1 failed");
        } else {
            System.out.println("lastRemaining1 pass");
        }
        if (lastRemaining2(n, m) != result) {
            System.out.println("lastRemaining2 failed");
        } else {
            System.out.println("lastRemaining2 pass");
        }
    }
}
