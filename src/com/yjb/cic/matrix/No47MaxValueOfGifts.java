package com.yjb.cic.matrix;

/**
 * 面试题47：礼物的最大价值
 * 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
 * （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
 * 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
 * 算你最多能拿到多少价值的礼物？
 */
public class No47MaxValueOfGifts {

    /**
     * 参考：
     * http://blog.csdn.net/koala_tree/article/details/79550438
     */
    private static int getMaxValue1(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int rows = values.length;
        int cols = values[0].length;
        int[][] dp = new int[rows][cols];// dp[row][col] 表示从(0, 0)到(row, col)的最大价值
        dp[0][0] = values[0][0];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int left = 0;
                int up = 0;
                if (col > 0) {
                    left = dp[row][col - 1];
                }
                if (row > 0) {
                    up = dp[row - 1][col];
                }
                dp[row][col] = Math.max(left, up) + values[row][col]; // 递推公式
            }
        }
        return dp[rows - 1][cols - 1];
    }

    /**
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     */
    private static int getMaxValue2(int[][] values) {
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int cols = values[0].length;
        int[] dp = new int[cols];// dp存放上一行所有的maxValue值
        for (int[] row : values) { // row存放当前行的所有value值
            dp[0] += row[0];
            for (int j = 1; j < cols; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + row[j];
            }
        }
        return dp[cols - 1];
    }
}
