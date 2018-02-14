package com.yjb.cic.math;

/**
 * 面试题16：数值的整数次方
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class No16Power {

    public static void main(String[] args) {
        // 底数、指数都为正数
        test("Test1", 2, 3, 8);
        // 底数为负数、指数为正数
        test("Test2", -2, 3, -8);
        // 指数为负数
        test("Test3", 2, -3, 0.125);
        // 指数为0
        test("Test4", 2, 0, 1);
        // 底数、指数都为0
        test("Test5", 0, 0, 1);
        // 底数为0、指数为正数
        test("Test6", 0, 4, 0);
        // 底数为0、指数为负数
//        test("Test7", 0, -4, Double.POSITIVE_INFINITY); // 异常
    }

    private static boolean equal(double num1, double num2) {
        return (num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001);
    }

    private static void test(String testName, double base, int exponent, double expectedResult) {
        double result = power(base, exponent);
        if (equal(result, expectedResult)) {
            System.out.println(testName + " passed");
        } else {
            System.out.println(testName + " FAILED");
        }
    }

    private static double power(double base, int exponent) {
        if (equal(base, 0.0) && exponent < 0) {
            throw new ArithmeticException("/ by zero");
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        double half = power(base, exponent >> 1);
        return (exponent & 1) == 0 ? half * half : half * half * base;
    }
}
