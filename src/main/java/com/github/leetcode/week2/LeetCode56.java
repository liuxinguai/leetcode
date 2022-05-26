package com.github.leetcode.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class LeetCode56 {

    public List<List<Integer>> solute(int[][] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr, (w1, w2) -> w1[0] < w2[0] ? -1 : 1);
        int right = arr[0][1];
        int left = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            if (right < arr[i][0]) {
                result.add(Arrays.asList(left,right));
                left = arr[i][0];
                right = arr[i][1];
            } else {
                if (right < arr[i][1]) {
                    right = arr[i][1];
                }
            }
        }
        return result;
    }

}
