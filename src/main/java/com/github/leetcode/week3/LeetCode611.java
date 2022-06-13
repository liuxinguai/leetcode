package com.github.leetcode.week3;

import java.util.Arrays;

/**
 * 611 有效三角形的个数
 * @author xinguai.liu
 */
public class LeetCode611 {

    public int solute(int[] arr) {
        int result = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                while (k + 1 < arr.length && arr[k + 1] < arr[i] + arr[j]) {
                    k++;
                }
                result += Math.max(k - j,0);
            }
        }
        return result;
    }

}
