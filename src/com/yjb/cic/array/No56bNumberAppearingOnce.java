package com.yjb.cic.array;

/**
 * 面试题56（二）：数组中唯一只出现一次的数字
 * 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
 * 找出那个吃出现一次的数字。
 */
public class No56bNumberAppearingOnce {

    private static int findNumberAppearingOnce(int nums[]) {
        if (nums == null || nums.length <= 0) {
            throw new IllegalArgumentException();
        }

        int[] bitSum = new int[32];
        for (int num : nums) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = num & bitMask;
                if (bit != 0)
                    bitSum[j] += 1;

                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }

        return result;
    }
}
