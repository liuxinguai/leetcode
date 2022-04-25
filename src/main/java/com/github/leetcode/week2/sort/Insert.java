package com.github.leetcode.week2.sort;

import java.util.List;

/**
 * @author xinguai.liu
 */
public class Insert implements Sort<Integer> {

    @Override
    public void sort(List<Integer> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j > 0 && data.get(j) < data.get(j - 1); j--) {
                int tmp = data.get(j);
                data.set(j,data.get(j - 1));
                data.set(j - 1,tmp);
            }
        }
    }


}
