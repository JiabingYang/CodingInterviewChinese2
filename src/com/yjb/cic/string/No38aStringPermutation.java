package com.yjb.cic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 面试题38：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
 * 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class No38aStringPermutation {

    /* ---------------- solution1 -------------- */

    /**
     * 修改自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test28.java
     * <p>
     * 书上的思路
     */
    private static void permutation(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        permutation(chars, 0);
    }

    private static void permutation(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            System.out.print(new String(chars) + " ");
            return;
        }
        for (int i = begin; i < chars.length; i++) {
            char tmp = chars[begin];
            chars[begin] = chars[i];
            chars[i] = tmp;
            permutation(chars, begin + 1);
            // 下面三行如果不写也没关系（可以不交换回来）
            tmp = chars[begin];
            chars[begin] = chars[i];
            chars[i] = tmp;
        }
    }

    /* ---------------- mySolution -------------- */

    /**
     * 和剑指offer的解法不同。效率较低。
     * 对于abc，先求解bc的全排列，再将a插入bc中，得到所有排列。
     * <p>
     * 写的时候没看函数定义，用String写的，用字符数组会有高得多的效率（插入操作的效率还是会很低）
     * 如果用数组写，思路是一样的
     * 不推荐的写法
     */
    private static void mySolution(String a) {
        for (String s : coreMySolution(a)) {
            System.out.print(s + " ");
        }
    }

    private static List<String> coreMySolution(String a) {
        if (a.length() < 2) {
            return Collections.singletonList(a);
        }
        if (a.length() == 2) {
            return Arrays.asList(a, String.valueOf(a.charAt(1)) + a.charAt(0));
        }
        List<String> subPermutation = coreMySolution(a.substring(1));
        List<String> result = new ArrayList<>();
        char head = a.charAt(0);
        for (String s : subPermutation) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i <= s.length(); i++) {
                sb.insert(i, head);
                result.add(sb.toString());
                sb.deleteCharAt(i);
            }
        }
        return result;
    }

    /* ---------------- test -------------- */
    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }
}
