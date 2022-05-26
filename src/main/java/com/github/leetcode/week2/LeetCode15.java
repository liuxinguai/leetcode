package com.github.leetcode.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class LeetCode15 {

    public List<List<Integer>> solute(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > 0) {
                break;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int leftResult = arr[left];
                int rightResult = arr[right];
                int sum = leftResult + rightResult + arr[i];
                if (sum > 0) {
                    right --;
                } else if (sum < 0) {
                    left ++;
                } else {
                    result.add(Arrays.asList(leftResult,rightResult,arr[i]));
                    while (left < right && arr[left] == arr[left+1]) {
                        left ++;
                    }
                    while (left < right && arr[right] == arr[right - 1]) {
                        right --;
                    }
                    left ++;
                    right --;
                }
            }
        }
        return result;
    }

}
