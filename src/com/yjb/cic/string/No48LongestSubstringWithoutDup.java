package com.yjb.cic.string;

import java.util.Arrays;

/**
 * 面试题48：最长不含重复字符的子字符串
 * 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
 * 字符串的长度。假设字符串中只包含从'a'到'z'的字符。
 */
public class No48LongestSubstringWithoutDup {

    /**
     * 修改自：
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     * <p>
     * 思路和书上一样
     * 比我的做法快
     */
    private static int longestSubStringWithoutDuplication(String str) {
        int[] bucket = new int[26];
        Arrays.fill(bucket, -1);

        int len = 0;
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            int prevIndex = bucket[c];
            if (prevIndex == -1 || i - prevIndex > len) {
                len++;
            } else {
                max = Math.max(max, len);
                len = i - prevIndex;
            }
            bucket[c] = i;
        }

        return Math.max(max, len);
    }

    private static int mySolution(String str) {
        if (str.length() <= 1) {
            return str.length();
        }

        int[] bucket = new int[26];
        Arrays.fill(bucket, -1);

        int max = 1;
        int left = 0;
        bucket[str.charAt(0) - 'a'] = 0;

        for (int right = 1; right < str.length(); right++) {
            int c = str.charAt(right) - 'a';
            int prevIndex = bucket[c];
            if (prevIndex != -1) {
                for (int i = left; i <= prevIndex; i++) {
                    bucket[str.charAt(i) - 'a'] = -1;
                }
                left = prevIndex + 1;
            }
            bucket[c] = right;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    /* ---------------- test -------------- */
    public static void main(String[] args) {
        test("abcacfrar", 4);
        test("acfrarabc", 4);
        test("arabcacfr", 4);
        test("aaaa", 1);
        test("abcdefg", 7);
        test("aaabbbccc", 2);
        test("abcdcba", 4);
        test("abcdaef", 6);
        test("a", 1);
        test("", 0);
    }

    private static void test(String str, int result) {
        System.out.println("[" + str + ", " + result + "] " + (longestSubStringWithoutDuplication(str) == result));
    }
}
