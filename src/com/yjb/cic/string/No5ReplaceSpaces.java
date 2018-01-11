package com.yjb.cic.string;

import java.util.Arrays;

/**
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”。
 * <p>
 * 双指针，从后往前复制
 * 时间n 空间1
 */
public class No5ReplaceSpaces {

    public static void main(String[] args) {
        System.out.println(replaceBlank("hello world".toCharArray()));
        System.out.println(replaceBlank(" helloworld".toCharArray()));
        System.out.println(replaceBlank("helloworld ".toCharArray()));
        System.out.println(replaceBlank("hello  world".toCharArray()));
        System.out.println(replaceBlank(null));
        System.out.println(replaceBlank(" ".toCharArray()));
        System.out.println(replaceBlank("   ".toCharArray()));
    }

    private static String replaceBlank(char[] str) {
        if (str == null) {
            return null;
        }
        int count = 0;
        for (char c : str) {
            if (c == ' ') {
                count++;
            }
        }
        char[] result = Arrays.copyOf(str, str.length + 2 * count);
        int i = str.length - 1;
        int j = result.length - 1;
        while (i >= 0) {
            if (result[i] == ' ') {
                result[j] = '0';
                result[j - 1] = '2';
                result[j - 2] = '%';
                j -= 3;
            } else {
                result[j] = result[i];
                j--;
            }
            i--;
        }
        return new String(result);
    }
}
