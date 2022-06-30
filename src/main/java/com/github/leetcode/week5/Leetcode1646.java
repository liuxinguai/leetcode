package com.github.leetcode.week5;

/**
 * @author xinguai.liu
 */
public class Leetcode1646 {

    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i % 2 == 0 ? dp[i / 2] : dp[i / 2] + dp[i / 2 + 1];
            max = Integer.max(max,dp[i]);
        }
        return max;
    }

}
