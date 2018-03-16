package com.yjb.cic.math;

/**
 * 面试题46：把数字翻译成字符串
 * 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻
 * 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
 * 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
 * "mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */
public class No46TranslateNumbersToStrings {

    /**
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     * https://www.jianshu.com/p/80e1841909b7
     */
    private static int getTranslationCount(String number) {
        int len = number.length();

        int[] dp = new int[len + 1]; // dp(r)表示从r开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数
        dp[len - 1] = dp[len] = 1; // 基本情况

        for (int i = len - 2; i >= 0; i--) {
            dp[i] = dp[i + 1];
            int converted = Integer.valueOf(number.substring(i, i + 2));
            if (converted >= 10 && converted <= 25) { // 如果number.substring(i, i + 2)能翻译，那么加上dp[i + 2]
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
