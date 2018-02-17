package com.yjb.cic.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * 不同于No38aStringPermutation的是:
 * 求字符的所有组合（非空子集）
 * <p>
 * 参考LeetCode:
 * 77. Combinations
 * 78. Subsets
 */
public class No38cStringCombination {

    /* ---------------- solution3 -------------- */

    /**
     * 参考自:
     * 我的leetcode仓库的No078Subsets#solution1
     */
    private static List<String> solution3(char[] chars) {
        List<String> result = new ArrayList<>();
        if (chars == null || chars.length == 0) {
            return result;
        }
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        result.add("");
        for (char c : set) {
            // 对每一个c来说，对当前result里的每个结果（上轮的）加入c生成新的结果加入result中
            int size = result.size();
            for (int j = 0; j < size; j++) {
                result.add(result.get(j) + c);
            }
        }
        result.remove("");
        return result;
    }

    /* ---------------- solution2 -------------- */

    /**
     * 参考自:
     * 我的leetcode仓库的No078Subsets#mySolution3
     */
    private static List<String> solution2(char[] chars) {
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        char[] charsNoDup = new char[set.size()];
        int i = 0;
        for (char c : set) {
            charsNoDup[i++] = c;
        }
        List<String> result = new ArrayList<>();
        dfs2(charsNoDup, 0, "", result);
        return result;
    }

    private static void dfs2(char[] chars, int start, String current, List<String> result) {
        for (int i = start; i < chars.length; i++) {
            String s = current + chars[i];
            result.add(s);
            dfs2(chars, i + 1, s, result);
        }
    }

    /* ---------------- solution1 -------------- */

    /**
     * 参考自:
     * 我的leetcode仓库的No077Combinations#solution2
     * (No077Combinations#solution1的写法在这里用不了，因为No077Combinations#solution1
     * 的dfs里用了for (int i = start; i <= n; i++)，而这里的set没法对其中一部分遍历)
     * <p>
     * dfs思路和书上的一样
     */
    private static List<String> solution1(char[] chars) {
        List<String> result = new ArrayList<>();
        TreeSet<Character> set = new TreeSet<>();
        for (char c : chars) {
            set.add(c);
        }
        for (int k = 1; k <= set.size(); k++) {
            dfs(set, k, "", result);
        }
        return result;
    }

    private static void dfs(TreeSet<Character> set, int k, String current, List<String> result) {
        if (k == 0) {
            result.add(current);
            return;
        }
        if (set.size() < k) {
            return;
        }
        char c = set.pollFirst();
        // 不选当前元素
        dfs(set, k, current, result);
        // 选择当前元素
        dfs(set, k - 1, current + String.valueOf(c), result);
        set.add(c);
    }

    /* ---------------- test -------------- */
    public static void main(String[] args) {
        System.out.println(solution2("aab".toCharArray()));
        System.out.println(solution2("aaabca".toCharArray()));
    }
}
