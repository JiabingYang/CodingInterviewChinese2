package com.yjb.cic.bit;

/**
 * 面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class No15NumberOf1InBinary {

    public static void main(String[] args) {
        test(0, 0);
        test(1, 1);
        test(10, 2);
        test(0x7FFFFFFF, 31);
        test(0xFFFFFFFF, 32);
        test(0x80000000, 1);
    }

    private static void test(int number, int expected) {
        if (numberOf1Better(number) != expected) {
            System.out.println("number = " + number);
        }
    }

    private static int numberOf1Basic(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >>> 1;
        }
        return result;
    }

    private static int numberOf1Better(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }
}
