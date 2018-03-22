package com.yjb.cic.string;

/**
 * 面试题67：把字符串转换成整数
 * 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
 * 能使用atoi或者其他类似的库函数。
 */
public class No67StringToInt {

    private static int mySolution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        boolean negative = str.charAt(0) == '-';
        int start = negative ? 1 : (str.charAt(0) == '+' ? 1 : 0);
        double result = 0;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            result = result * 10 + (c - '0');
        }
        result = negative ? -result : result;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
