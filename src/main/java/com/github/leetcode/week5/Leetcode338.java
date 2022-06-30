package com.github.leetcode.week5;

/**
 * 比特位计数
 * @author xinguai.liu
 */
public class Leetcode338 {

    public int countOne(int num) {
        int ones = 0;
        while (num > 0) {
            num &= (num - 1);
            ones++;
        }
        return ones;
    }

    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

    public int[] countBit3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public int[] countBits4(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        //100
        System.out.println(new Leetcode338().countOne(4));
        //101
        System.out.println(new Leetcode338().countOne(5)+","+Integer.toBinaryString(5));
        System.out.println(new Leetcode338().countOne(7)+","+Integer.toBinaryString(7));
    }

}
