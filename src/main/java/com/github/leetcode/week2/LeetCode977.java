package com.github.leetcode.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class LeetCode977 {

    public List<Integer> square(List<Integer> source) {
        List<Integer> result = new ArrayList<>(source.size());
        for (int i = 0; i < source.size(); i++) {
            result.add(0);
        }
        int index = source.size() - 1, right = index, left = 0;
        for (int i = index; i >= 0; i--) {
            int rightResult = source.get(right) * source.get(right);
            int leftResult = source.get(left) * source.get(left);
            if (rightResult >= leftResult) {
                result.set(i,rightResult);
                right --;
            } else {
                result.set(i,leftResult);
                left ++;
            }
        }
        return result;
    }

}
