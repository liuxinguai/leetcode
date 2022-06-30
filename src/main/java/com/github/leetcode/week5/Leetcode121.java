package com.github.leetcode.week5;

/**
 * 买卖股票的最佳时机
 * @author xinguai.liu
 */
public class Leetcode121 {

    public int maxProfit(int[] prices) {
        int start = prices[0],income = 0;
        for (int i = 0; i < prices.length; i++) {
            start = Integer.min(start, prices[i]);
            income = Integer.max(income,prices[i] - start);
        }
        return income;
    }

}
