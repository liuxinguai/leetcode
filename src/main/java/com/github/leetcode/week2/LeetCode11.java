package com.github.leetcode.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class LeetCode11 {

    public List<Integer> max(List<Integer> source) {
        int left = 0, right = source.size() - 1, max = 0;
        List<Integer> result = new ArrayList<>(3);
        result.add(left);
        result.add(right);
        result.add(0);
        while (left < right) {
            int leftResult = source.get(left);
            int rightResult = source.get(right);
            boolean leftMax = leftResult >= rightResult;
            max = (right - left) * (leftMax ? rightResult : rightResult);
            if (max > result.get(2)) {
                result.set(0,left);
                result.set(1,right);
                result.set(2,max);
            } else {
                if (leftMax) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return result;
    }

}
