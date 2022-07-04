package com.github.leetcode.offer;

/**
 * 二进制中1的个数
 * @author xinguai.liu
 */
public class Offer15 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n &= n-1;
        }
        return count;
    }

}
