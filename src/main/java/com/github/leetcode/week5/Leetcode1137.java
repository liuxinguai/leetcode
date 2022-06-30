package com.github.leetcode.week5;

/**
 * @author xinguai.liu
 */
public class Leetcode1137 {

    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Leetcode1137().tribonacci(4);
    }
    
}
