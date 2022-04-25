package com.github.leetcode.week2.sort;

import java.util.List;

/**
 * @author xinguai.liu
 */
public class Bubble implements Sort<Integer> {

    @Override
    public void sort(List<Integer> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    int tmp = data.get(j);
                    data.set(j,data.get(j+1));
                    data.set(j+1,tmp);
                }
            }
        }
    }
}
