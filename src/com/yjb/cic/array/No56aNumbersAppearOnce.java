package com.yjb.cic.array;

/**
 * 面试题56（一）：数组中只出现一次的两个数字
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class No56aNumbersAppearOnce {

    /**
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     */
    private static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int diff = 0;
        for (int num : array) {
            diff ^= num;
        }
        diff &= -diff; // 得到最右一位
        for (int num : array) {
            if ((num & diff) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }
}
