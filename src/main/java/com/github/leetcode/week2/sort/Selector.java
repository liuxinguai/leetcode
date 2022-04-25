package com.github.leetcode.week2.sort;

import java.util.List;

/**
 * @author xinguai.liu
 */
public class Selector implements Sort<Integer>{

    @Override
    public void sort(List<Integer> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.size(); j++) {
                minIndex = data.get(j) < data.get(minIndex) ? j : minIndex;
            }
            int tmp = data.get(i);
            data.set(i,data.get(minIndex));
            data.set(minIndex,tmp);
        }
    }

}
