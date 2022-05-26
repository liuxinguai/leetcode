package com.github.leetcode.week2;

import java.util.*;

/**
 * @author xinguai.liu
 */
public class LeetCode1 {

    public List<Integer> answer(List<Integer> source, int target) {
        Map<Integer, Integer> sourceMap = new HashMap<>(source.size());
        for (int i = 0; i < source.size(); i++) {
            int another = target - source.get(i);
            if (sourceMap.containsKey(another)) {
                List<Integer> result = new ArrayList<>();
                result.add(i);
                result.add(sourceMap.get(another));
                return result;
            } else {
                sourceMap.put(source.get(i), i);
            }
        }
        return new ArrayList();
    }
}
