package com.yjb.cic.array;

/**
 * 面试题63：股票的最大利润
 * 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
 * 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
 * 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
 * 收获最大的利润11。
 */
public class No63MaximalProfit {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{9, 11, 8, 5, 7, 12, 16, 14}));
    }

    /**
     * https://github.com/CyC2018/Interview-Notebook/blob/master/notes/剑指%20offer%20题解.md
     */
    private static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < soFarMin) {
                soFarMin = prices[i];
            } else {
                max = Math.max(max, prices[i] - soFarMin);
            }
        }
        return max;
    }
}
