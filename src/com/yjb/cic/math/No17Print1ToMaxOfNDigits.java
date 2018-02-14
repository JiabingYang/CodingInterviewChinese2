package com.yjb.cic.math;

/**
 * 面试题17：打印1到最大的n位数
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 */
public class No17Print1ToMaxOfNDigits {

    public static void main(String[] args) {
        System.out.println("print1ToMaxOfNDigits1");
        print1ToMaxOfNDigits1(2);
        System.out.println("print1ToMaxOfNDigits2");
        print1ToMaxOfNDigits2(2);
    }

    /* ---------------- print1ToMaxOfNDigits1 -------------- */

    /**
     * 用数组存数字
     * 每次在数组上+1
     */
    private static void print1ToMaxOfNDigits1(int n) {
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        int[] arr = new int[n];
        while (increment(arr)) {
            printNumber(arr);
        }
    }

    private static boolean increment(int[] arr) {
        int index = arr.length - 1;
        int carry = 1;
        while (carry != 0 && index >= 0) {
            arr[index] += carry;
            carry = arr[index] / 10;
            arr[index] %= 10;
            index--;
        }
        return carry == 0 || index != -1;
    }

    /* ---------------- print1ToMaxOfNDigits2 -------------- */

    /**
     * 用数组存数字
     * 递归求全排列
     */
    private static void print1ToMaxOfNDigits2(int n) {
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        int[] arr = new int[n];
        print1ToMaxOfNDigits2Core(0, arr);
    }

    private static void print1ToMaxOfNDigits2Core(int n, int[] arr) {
        if (n == arr.length) {
            printNumber(arr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            arr[n] = i;
            print1ToMaxOfNDigits2Core(n + 1, arr);
        }
    }

    /* ---------------- 依赖 -------------- */

    private static void printNumber(int[] arr) {
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        if (index < arr.length) {
            System.out.println();
        }
    }
}
