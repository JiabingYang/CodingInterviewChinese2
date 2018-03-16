package com.yjb.cic.math;

/**
 * 面试题44：数字序列中某一位的数字
 * 题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这
 * 个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一
 * 个函数求任意位对应的数字。
 */
public class No44DigitsInSequence {

    /**
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     */
    private static int digitAtIndex(int index) {
        if (index < 0) return -1;
        int digit = 1;
        while (true) {
            int amount = getAmountOfDigit(digit);
            if (index < amount) {
                return digitAtIndex(index, digit);
            }
            index -= amount;
            digit++;
        }
    }

    /**
     * digit位数的所有数字的字符串长度和
     * 例如 digit = 2， return 90
     */
    private static int getAmountOfDigit(int digit) {
        if (digit == 1) {
            return 10;
        }
        return (int) Math.pow(10, digit - 1) * 9 * digit;
    }

    /**
     * 在digit位数组成的字符串中，第index位上的数
     */
    private static int digitAtIndex(int index, int digit) {
        int number = beginNumber(digit) + index / digit; // 第index位所在的digit位数
        int remain = index % digit; // 第index位所在的digit位数中的位置
        return (number + "").charAt(remain) - '0';
    }

    /**
     * digit 位数的起始数字
     * 例如 digit = 2 return 10
     */
    private static int beginNumber(int digit) {
        if (digit == 1) {
            return 0;
        }
        return (int) Math.pow(10, digit - 1);
    }
}
