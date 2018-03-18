package com.yjb.cic.array;

import java.util.Arrays;

/**
 * 面试题61：扑克牌的顺子
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 */
public class No61ContinousCards {

    /**
     * https://github.com/CyC2018/Interview-Notebook/blob/master/notes/剑指%20offer%20题解.md
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);

        int zeroCount = 0;
        for (int num : numbers) {
            if (num == 0) {
                zeroCount++;
            }
        }

        for (int i = zeroCount; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            int interval = numbers[i + 1] - numbers[i] - 1;
            if (interval > zeroCount) {
                return false;
            }
            zeroCount -= interval;
        }

        return true;
    }
}
