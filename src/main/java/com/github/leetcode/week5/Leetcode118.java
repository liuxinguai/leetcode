package com.github.leetcode.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class Leetcode118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> levelList = new ArrayList<>();
            result.add(levelList);
            int parentLevel = i - 1;
            for (int j = 0; j <= i; j++) {
                if (parentLevel == -1) {
                    levelList.add(1);
                    continue;
                }
                if (j - 1 == -1 || j >= result.get(parentLevel).size()) {
                    levelList.add(1);
                } else {
                    levelList.add(result.get(parentLevel).get(j - 1) + result.get(parentLevel).get(j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Leetcode118().generate(5);
    }

}
