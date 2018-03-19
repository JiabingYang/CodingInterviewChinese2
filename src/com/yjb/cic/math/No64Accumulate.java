package com.yjb.cic.math;

/**
 * 面试题64：求1+2+…+n
 * 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 */
public class No64Accumulate {

    /**
     * https://github.com/CyC2018/Interview-Notebook/blob/master/notes/剑指%20offer%20题解.md
     */
    private static int sum1(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += sum1(n - 1)) > 0);
        return sum;
    }

    /**
     * http://blog.csdn.net/zjkc050818/article/details/72458184
     */
    public int sum2(int n) {
        return (int) (Math.pow((double) n, 2) + n) >> 1;
    }
}
