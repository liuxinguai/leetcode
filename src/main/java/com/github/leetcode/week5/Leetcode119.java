package com.github.leetcode.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * @author xinguai.liu
 */
public class Leetcode119 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    level.add(1);
                } else {
                    level.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(level);
        }
        return result.get(result.size() - 1);
    }

    public static void main(String[] args) {
        new Leetcode119().getRow(3);
    }

}
