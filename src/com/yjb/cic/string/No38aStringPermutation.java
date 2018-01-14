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

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();

        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }

    private static void permutation(char[] chars) {
        // 输入较验
        if (chars == null || chars.length < 1) {
            return;
        }
        // 进行排列操作
        permutation(chars, 0);
    }

    private static void permutation(char[] chars, int begin) {
        // 如果是最后一个元素了，就输出排列结果
        if (chars.length - 1 == begin) {
            System.out.print(new String(chars) + " ");
            return;
        }
        char tmp;
        // 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
        for (int i = begin; i < chars.length; i++) {
            // 下面是交换元素的位置
            tmp = chars[begin];
            chars[begin] = chars[i];
            chars[i] = tmp;

            // 处理下一个位置
            permutation(chars, begin + 1);
        }
    }

    /**
     * 和剑指offer的解法不同。效率较低。
     * 对于abc，先求解bc的全排列，再将a插入bc中，得到所有排列。
     * <p>
     * 写的时候没看函数定义，用String写的，用字符数组会有高得多的效率（插入操作的效率还是会很低）
     * 如果用数组写，思路是一样的
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
}
