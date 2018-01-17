package com.yjb.cic.backtrace;

/**
 * 面试题13：机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class No13RobotMove {

    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, visited, 0, 0);
    }

    private static int movingCountCore(int threshold, int rows, int cols,
                                       boolean[] visited, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i * cols + j] || getDigitsSum(i, j) > threshold) {
            return 0;
        }
        visited[i * cols + j] = true;
        int sum = movingCountCore(threshold, rows, cols, visited, i - 1, j) +
                movingCountCore(threshold, rows, cols, visited, i, j - 1) +
                movingCountCore(threshold, rows, cols, visited, i + 1, j) +
                movingCountCore(threshold, rows, cols, visited, i, j + 1);
        return sum + 1;
    }

    private static int getDigitsSum(int a, int b) {
        int sum = 0;
        while (a != 0 || b != 0) {
            if (a != 0) {
                sum += a % 10;
                a /= 10;
            }
            if (b != 0) {
                sum += b % 10;
                b /= 10;
            }
        }
        return sum;
    }

    /**
     * 测试用例来自：
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test67.java
     */
    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(15, 20, 20) + "[359]");
        System.out.println(movingCount(10, 1, 100) + "[29]");
        System.out.println(movingCount(10, 1, 10) + "[10]");
        System.out.println(movingCount(15, 100, 1) + "[79]");
        System.out.println(movingCount(15, 10, 1) + "[10]");
        System.out.println(movingCount(5, 10, 10) + "[21]");
        System.out.println(movingCount(12, 1, 1) + "[1]");
        System.out.println(movingCount(-10, 10, 10) + "[0]");
    }
}
