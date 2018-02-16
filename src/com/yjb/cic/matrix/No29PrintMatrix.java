package com.yjb.cic.matrix;

/**
 * 面试题29：顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class No29PrintMatrix {

    private static void printMatrixClockWisely(int[][] numbers) {
        if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
            return;
        }
        int max = Math.min((numbers[0].length + 1) / 2, (numbers.length + 1) / 2);
        for (int i = 0; i < max; i++) {
            printMatrixInCircle(numbers, i);
        }
    }

    /**
     * 四个for循环依次按下图打印:
     * --->
     * ^  |
     * |  |
     * <--v
     * 第一个for循环肯定打印，第二个for循环在循环条件满足时打印，第三个for循环在非单行时打印，第四个for循环在非单列时打印
     */
    private static void printMatrixInCircle(int[][] numbers, int leftTop) {
        int right = numbers[0].length - leftTop - 1;
        int bottom = numbers.length - leftTop - 1;
        for (int i = leftTop; i <= right; i++) {
            System.out.print(numbers[leftTop][i] + " ");
        }
        for (int i = leftTop + 1; i <= bottom; i++) {
            System.out.print(numbers[i][right] + " ");
        }
        if (leftTop != bottom) {
            for (int i = right - 1; i >= leftTop; i--) {
                System.out.print(numbers[bottom][i] + " ");
            }
        }
        if (leftTop != right) {
            for (int i = bottom - 1; i > leftTop; i--) {
                System.out.print(numbers[i][leftTop] + " ");
            }
        }
    }

    /* ---------------- test -------------- */

    /**
     * 测试代码来自:
     * https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test20.java
     */
    public static void main(String[] args) {
        System.out.println("numbers");
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        printMatrixClockWisely(numbers);
        System.out.println();

        System.out.println("numbers2");
        int[][] numbers2 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {22, 23, 24, 25, 26, 27, 28, 9},
                {21, 36, 37, 38, 39, 40, 29, 10},
                {20, 35, 34, 33, 32, 31, 30, 11},
                {19, 18, 17, 16, 15, 14, 13, 12},

        };
        printMatrixClockWisely(numbers2);
        System.out.println();

        System.out.println("numbers3");
        int[][] numbers3 = {
                {1, 2, 3, 4, 5, 6, 7, 8}
        };
        printMatrixClockWisely(numbers3);
        System.out.println();

        System.out.println("numbers4");
        int[][] numbers4 = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {16, 15, 14, 13, 12, 11, 10, 9}
        };
        printMatrixClockWisely(numbers4);
        System.out.println();

        System.out.println("numbers5");
        int[][] numbers5 = {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8}
        };
        printMatrixClockWisely(numbers5);
        System.out.println();

        System.out.println("numbers6");
        int[][] numbers6 = {
                {0, 1},
                {15, 2},
                {14, 3},
                {13, 4},
                {12, 5},
                {11, 6},
                {10, 7},
                {9, 8}
        };
        printMatrixClockWisely(numbers6);
        System.out.println();

        System.out.println("numbers7");
        int[][] numbers7 = {
                {1, 2},
                {4, 3}
        };
        printMatrixClockWisely(numbers7);
        System.out.println();

        System.out.println("numbers8");
        int[][] numbers8 = {
                {1}
        };
        printMatrixClockWisely(numbers8);
        System.out.println();

        // 0个元素的数组
        System.out.println("0个元素的数组");
        printMatrixClockWisely(new int[][]{{}});
        System.out.println();

        // 空数组
        System.out.println("空数组");
        printMatrixClockWisely(null);
    }
}
