package com.yjb.cic.string;

/**
 * 面试题50（一）：字符串中第一个只出现一次的字符
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 */
public class No50aFirstNotRepeatingChar {

    /**
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     */
    private static int FirstNotRepeatingChar(String str) {
        int[] counts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
