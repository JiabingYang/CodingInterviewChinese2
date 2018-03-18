package com.yjb.cic.string;

/**
 * 面试题58（二）：左旋转字符串
 * 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数
 * 字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 * <p>
 * Leetcode: 189. Rotate Array
 */
public class No58bLeftRotateString {

    public static void main(String[] args) {
        System.out.println(mySolution("", 9));
        System.out.println(mySolution("abcdefg", 2));
        System.out.println(mySolution("abcdefg", 9));
    }

    private static String mySolution(String str, int k) {
        if (str == null || str.length() == 0 || (k = k % str.length()) == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, k - 1);
        reverse(chars, k, chars.length - 1);
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
