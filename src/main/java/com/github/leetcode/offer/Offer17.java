package com.github.leetcode.offer;

/**
 * 打印从1到最大的n位数
 * @author xinguai.liu
 */
public class Offer17 {

    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n) - 1;
        int[] result = new int[max];
        for (int i = 1; i <= max; i++) {
            result[i-1] = i;
        }
        return result;
    }

}
