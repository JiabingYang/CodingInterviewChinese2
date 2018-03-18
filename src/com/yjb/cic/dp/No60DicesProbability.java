package com.yjb.cic.dp;

/**
 * 面试题60：n个骰子的点数
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
 * 的所有可能的值出现的概率。
 */
public class No60DicesProbability {

    public static void main(String[] args) {
        System.out.println(countProbability1(3, 12));
        System.out.println(countProbability2(3, 12));
        System.out.println(countProbability1(1, 5));
        System.out.println(countProbability2(1, 5));
    }

    /**
     * 修改自：
     * https://github.com/CyC2018/Interview-Notebook/blob/master/notes/剑指%20offer%20题解.md
     * 思路来自：
     * http://blog.csdn.net/k346k346/article/details/50988681
     * <p>
     * dp
     * <p>
     * 解题思路：
     * 第一步，确定问题解的表达式。可将f(n, s) 表示n个骰子点数的和为s的排列情况总数。
     * 第二步，确定状态转移方程。n个骰子点数和为s的种类数只与n-1个骰子的和有关。
     * 因为一个骰子有六个点数，那么第n个骰子可能出现1到6的点数。
     * 所以第n个骰子点数为1的话，f(n,s)=f(n-1,s-1)，当第n个骰子点数为2的话，f(n,s)=f(n-1,s-2)，…，依次类推。
     * 在n-1个骰子的基础上，再增加一个骰子出现点数和为s的结果只有这6种情况！那么有：
     * f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6) ，0< n<=6n
     * f(n,s)=0, s< n or s>6n
     * <p>
     * 当n=1时, f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1
     * <p>
     * 时间n2 空间n2
     */
    private static double countProbability1(int n, int s) {
        if (n < 1 || s < n || s > 6 * n) {
            return 0.0;
        }
        int[][] dp = new int[n][6 * n]; // i = n - 1; j = s - 1;
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        return dp[n - 1][s - 1] / Math.pow(6, n);
    }

    /**
     * 修改自：
     * https://github.com/CyC2018/Interview-Notebook/blob/master/notes/剑指%20offer%20题解.md
     * 思路来自：
     * http://blog.csdn.net/k346k346/article/details/50988681
     * <p>
     * dp + 替换数组
     * <p>
     * 解题思路：
     * 第一步，确定问题解的表达式。可将f(n, s) 表示n个骰子点数的和为s的排列情况总数。
     * 第二步，确定状态转移方程。n个骰子点数和为s的种类数只与n-1个骰子的和有关。
     * 因为一个骰子有六个点数，那么第n个骰子可能出现1到6的点数。
     * 所以第n个骰子点数为1的话，f(n,s)=f(n-1,s-1)，当第n个骰子点数为2的话，f(n,s)=f(n-1,s-2)，…，依次类推。
     * 在n-1个骰子的基础上，再增加一个骰子出现点数和为s的结果只有这6种情况！那么有：
     * f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6) ，0< n<=6n
     * f(n,s)=0, s< n or s>6n
     * <p>
     * 当n=1时, f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1
     * <p>
     * 时间n2 空间n
     */
    private static double countProbability2(int n, int s) {
        if (n < 1 || s < n || s > 6 * n) {
            return 0.0;
        }
        int[][] dp = new int[2][6 * n];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        int flag = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < 6 * n; j++) { // 使用 i 个骰子最小点数为 i
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0) {
                        dp[flag][j] += dp[1 - flag][j - k];
                    }
                }
            }
            flag = 1 - flag;
        }
        return dp[1 - flag][s - 1] / Math.pow(6, n);
    }
}
