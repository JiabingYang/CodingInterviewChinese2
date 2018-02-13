package com.yjb.cic.dpgreedy;

/**
 * 面试题14：剪绳子
 * 题目：给你一根长度为n的绳子，请把绳子剪成m段(m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class No14CuttingRope {

    public static void main(String[] args) {
        System.out.println(maxProductAfterCuttingGreedy(1) + "[0]");
        System.out.println(maxProductAfterCuttingGreedy(2) + "[1]");
        System.out.println(maxProductAfterCuttingGreedy(3) + "[2]");
        System.out.println(maxProductAfterCuttingGreedy(4) + "[4]");
        System.out.println(maxProductAfterCuttingGreedy(5) + "[6]");
        System.out.println(maxProductAfterCuttingGreedy(6) + "[9]");
        System.out.println(maxProductAfterCuttingGreedy(7) + "[12]");
        System.out.println(maxProductAfterCuttingGreedy(8) + "[18]");
        System.out.println(maxProductAfterCuttingGreedy(9) + "[27]");
        System.out.println(maxProductAfterCuttingGreedy(10) + "[36]");
        System.out.println(maxProductAfterCuttingGreedy(50) + "[86093442]");
    }

    /**
     * dp
     * 时间n2 空间n
     */
    private static int maxProductAfterCuttingDp1(int length) {
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[length + 1];
        for (int i = 2; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                // 实际上，i >= 4时dp[i]肯定>=i，所以只需要写dp[1],dp[2],dp[3]，
                // 然后4开始直接max = Math.max(max, dp[j] * dp[i - j]);
                // 见maxProductAfterCuttingDp2
                max = Math.max(max, Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[length];
    }

    /**
     * dp
     * 时间n2 空间n
     */
    private static int maxProductAfterCuttingDp2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] dp = new int[length + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[j] * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[length];
    }

    /**
     * 贪婪
     * 时间n 空间1
     */
    private static int maxProductAfterCuttingGreedy(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timeOf3 = length / 3;
        int remainder = length - timeOf3 * 3;
        if (remainder == 0) {
            return (int) (Math.pow(3, timeOf3));
        } else if (remainder == 1){
            return (int) (Math.pow(3, timeOf3 - 1)) * 4;
        } else {
            return (int) (Math.pow(3, timeOf3)) * 2;
        }
    }
}
