package com.github.leetcode.week2;

import java.util.Arrays;

/**
 * @author xinguai.liu
 */
public class LeetCode452 {

    public int answer(int[][] arr) {
        int result = 0;
        Arrays.sort(arr, (w1, w2) -> w1[0] < w2[0] ? -1 : 1);
        int right = arr[0][1];
        System.out.printf("[%d,%d]",arr[0][0],arr[0][1]);
        for (int i = 1; i < arr.length; i++) {
            if (right < arr[i][0]) {
                result ++;
                right = arr[i][1];
            } else {
                if (arr[i][1] < right) {
                    right = arr[i][1];
                }
            }
            System.out.printf(",[%d,%d]",arr[i][0],arr[i][1]);
        }
        System.out.println();
        return result;
    }

}
