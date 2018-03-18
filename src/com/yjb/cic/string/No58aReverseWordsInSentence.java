package com.yjb.cic.string;

/**
 * 面试题58（一）：翻转单词顺序
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 * <p>
 * Leetcode: 151. Reverse Words in a String
 */
public class No58aReverseWordsInSentence {

    public static void main(String[] args) {
        System.out.println(reverseSentence("the sky is blue"));
        System.out.println(reverseSentence("the sky"));
        System.out.println(reverseSentence("the"));
        System.out.println(reverseSentence(""));
    }

    private static String reverseSentence(String str) {
        if (str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        int l = 0;
        for (int r = 0; r <= chars.length; r++) {
            if (r == chars.length || chars[r] == ' ') {
                reverse(chars, l, r - 1);
                l = r + 1;
            }
        }
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
