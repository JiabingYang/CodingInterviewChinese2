package com.yjb.cic.math;

/**
 * 面试题49：丑数
 * 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
 * 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做第一个丑数。
 */
public class No49UglyNumber {

    /**
     * 修改自：
     * https://github.com/CyC2018/InnterviewNotes/blob/master/notes/剑指%20offer%20题解.md
     * 思路来自：
     * http://blog.csdn.net/leex_brave/article/details/51766194
     * <p>
     * 我们把现有的最大丑数记做M。现在我们来生成下一个丑数，该丑数肯定是前面某一个丑数乘以2、3或者5的结果。
     * <p>
     * 我们首先考虑把已有的每个丑数乘以2。在乘以2的时候，能得到若干个结果小于或等于M的。
     * 由于我们是按照顺序生成的，小于或者等于M肯定已经在数组中了，我们不需再次考虑；
     * 我们还会得到若干个大于M的结果，但我们只需要第一个大于M的结果，
     * 因为我们希望丑数是按从小到大顺序生成的，其他更大的结果我们以后再说。
     * 我们把得到的第一个乘以2后大于M的结果，记为M2。
     * <p>
     * 同样我们把已有的每一个丑数乘以3和5，能得到第一个大于M的结果M3和M5。
     * 那么下一个丑数应该是M2、M3和M5三个数的最小者。
     */
    private static int getUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int count = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        while (count < n) {
            int n2 = dp[i2] * 2, n3 = dp[i3] * 3, n5 = dp[i5] * 5;
            int min = Math.min(n2, Math.min(n3, n5));
            dp[count++] = min;
            if (min == n2) {
                i2++;
            }
            if (min == n3) {
                i3++;
            }
            if (min == n5) {
                i5++;
            }
        }
        return dp[n - 1];
    }
}
