package com.yjb.cic.string;

/**
 * 面试题19：正则表达式匹配
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
 * 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
 * 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
 * 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 * <p>
 * Leetcode: 10. Regular Expression Matching
 */
public class No19RegularExpressions {

    // ------------------------ solution1(回溯) ------------------------

    /**
     * 来自：
     * https://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
     * <p>
     * 5.85%
     * <p>
     * 回溯
     * <p>
     * 注：
     * 1. 简化了programcreek上的写法
     * 2. 从JDK1.7开始，subString()内部会复制字符数组，是O(n)操作，
     * 该解法需要优化的话，减少subString()调用的次数是最直接的。
     */
    private static boolean solution1(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.length() == 1) {
            return s.length() == 1 && (s.equals(p) || p.equals("."));
        }
        // p.length() >= 2
        if (p.charAt(1) != '*') { // p.charAt(1) != '*'
            return !s.isEmpty()
                    && ((p.charAt(0) == s.charAt(0)) || (p.charAt(0) == '.'))
                    && solution1(s.substring(1), p.substring(1));
        }
        // p.charAt(1) == '*'
        if (solution1(s, p.substring(2))) { // the '*' stands for 0 preceding element
            return true;
        }
        // the '*' stands for 1 or more preceding element
        // try every possible number
        int i = 0;
        while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
            if (solution1(s.substring(i + 1), p.substring(2))) {
                return true;
            }
            i++;
        }
        return false;
    }

    // ------------------------ solution2(回溯简化写法) ------------------------

    /**
     * https://www.cnblogs.com/grandyang/p/4461713.html
     * <p>
     * 回溯
     * <p>
     * solution1的简化写法
     * <p>
     * 11.82%
     */
    private static boolean solution2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            return solution2(s, p.substring(2)) // the '*' stands for 0 preceding element
                    // 当s不为空，且第一个字符和p的第一个字符相同时
                    // => 我们再对去掉首字符的s和p调用递归
                    || (!s.isEmpty()
                    && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && solution2(s.substring(1), p));
        }
        // p的第二个字符不为*或p不存在第二个字符 => 比较第一个字符，然后对后面的字符串调用递归
        return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                && solution2(s.substring(1), p.substring(1));
    }

    // ------------------------ solution3(dp) ------------------------

    /**
     * https://leetcode.com/problems/regular-expression-matching/discuss/5665/My-concise-recursive-and-DP-solutions-with-full-explanation-in-C++
     * <p>
     * 'match' below including .
     * dp(i,j)表示s[0,i-1]是否和p[0,j-1]匹配
     * 1. p.charAt(j-1) != *
     * dp(i,j) = dp(i-1,j-1) and s_i-1 matches p_j-1;
     * 2. p.charAt(j-1) == *
     * 2.1 matches zero times:
     * dp(i,j) = dp(i,j-2);
     * 2.2 matches at least one time:
     * dp(i,j) = dp(i-1,j) and s_i-1 matches p_j-2;
     * (即：s[0,i-1]是否和p[0,j-1]匹配 = s[0,i-2] matches p[0,j-1] 且 s_i-1 matches p_j-2;)
     * <p>
     * 42.50%
     */
    public boolean solution3(String s, String p) {
        if (!p.isEmpty() && p.charAt(0) == '*') {
            return false;   // invalid p
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // initialize dp(0,0)
        dp[0][0] = true;

        // dp(k,0) and dp(0,2k-1) where k>=1 are false by default

        // initialize dp(0,2k) where p_2k-1 = * for any k>=1
        for (int j = 1; j < p.length(); j += 2) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j - 1];
            }
        }

        // dp(0,k) and dp(k,0) has initialized
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && isCharMatch(s.charAt(i - 1), p.charAt(j - 1));
                } else {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && isCharMatch(s.charAt(i - 1), p.charAt(j - 2));
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    // no * in p
    private boolean isCharMatch(char s, char p) {
        return p == '.' || s == p;
    }
}
