package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题4：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 * <p>
 * 二分查找（注意二分的中点在哪儿（应该是矩阵右上角而不是矩阵中间点））
 * 时间logn 空间1
 */
public class No4FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        testIteration();
        testRecursion();
    }

    private static int[] findIteration(int[][] matrix, int number) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int rtX = matrix[0].length - 1;
        int rtY = 0;
        while (rtX >= 0 && rtY <= matrix.length - 1) {
            int rt = matrix[rtY][rtX];
            if (rt == number) {
                return new int[]{rtX, rtY};
            }
            if (rt > number) {
                rtX--;
                continue;
            }
            rtY++;
        }
        return null;
    }

    private static int[] findRecursion(int[][] matrix, int number) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        return findRecursion(matrix, number, matrix[0].length - 1, 0);
    }

    private static int[] findRecursion(int[][] matrix, int number, int rtX, int rtY) {
        if (rtX < 0 || rtY > matrix.length - 1) {
            return null;
        }
        int rt = matrix[rtY][rtX];
        if (rt == number) {
            return new int[]{rtX, rtY};
        }
        if (rt > number) {
            return findRecursion(matrix, number, rtX - 1, rtY);
        }
        return findRecursion(matrix, number, rtX, rtY + 1);
    }

    private static void testIteration() {
        System.out.println("---- testIteration ----");
        // 1,2
        System.out.println(Arrays.toString(findIteration(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 7)));
        // null
        System.out.println(Arrays.toString(findIteration(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 5)));
        // 0,0
        System.out.println(Arrays.toString(findIteration(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 1)));
        // 3,3
        System.out.println(Arrays.toString(findIteration(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 15)));
        // null
        System.out.println(Arrays.toString(findIteration(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 0)));
        // null
        System.out.println(Arrays.toString(findIteration(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 16)));
        // null
        System.out.println(Arrays.toString(findIteration(null, 16)));
    }

    private static void testRecursion() {
        System.out.println("---- testRecursion ----");
        // 1,2
        System.out.println(Arrays.toString(findRecursion(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 7)));
        // null
        System.out.println(Arrays.toString(findRecursion(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 5)));
        // 0,0
        System.out.println(Arrays.toString(findRecursion(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 1)));
        // 3,3
        System.out.println(Arrays.toString(findRecursion(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 15)));
        // null
        System.out.println(Arrays.toString(findRecursion(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 0)));
        // null
        System.out.println(Arrays.toString(findRecursion(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}}, 16)));
        // null
        System.out.println(Arrays.toString(findRecursion(null, 16)));
    }
}
