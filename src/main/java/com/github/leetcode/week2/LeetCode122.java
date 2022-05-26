package com.github.leetcode.week2;

/**
 * @author xinguai.liu
 */
public class LeetCode122 {

    public int solute(int[] arr) {
        return process(arr,0,0,0);
    }

    public int backUp(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; ++i) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }


    protected int process(int[] arr, int index, int hold, int profit) {
        if (index == arr.length - 1) {
            return hold > 0 && arr[index] - hold > 0 ? profit + arr[index] - hold : profit;
        }
        int maxProfit = 0;
        if (hold > 0) {
            int holdProfit = arr[index] - hold;
            if (holdProfit > 0 ) {
                int purchase = process(arr, index + 1, 0, profit + holdProfit);
                int noPurchase = process(arr, index + 1, hold, profit);
                maxProfit = Math.max(purchase,noPurchase);
            } else {
                maxProfit = process(arr, index + 1, hold, profit);
            }
        } else {
            int holder = process(arr, index + 1, arr[index], profit);
            int noHolder = process(arr, index + 1, 0, profit);
            maxProfit = Math.max(holder, noHolder);
        }
        return maxProfit;
    }

}
