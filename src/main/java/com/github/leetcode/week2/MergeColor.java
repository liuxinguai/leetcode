package com.github.leetcode.week2;

import java.util.List;

/**
 * @author xinguai.liu
 */
public class MergeColor {

    public void merge(List<Integer> data) {
        int index = 0;
        int leftIndex = index - 1;
        int rightIndex = data.size() - 1;
        while (index <= rightIndex) {
            if (data.get(index) <= 0) {
                swap(data,++leftIndex,index++);
            } else if (data.get(index) == 1){
                index ++;
            } else {
                swap(data,index,rightIndex--);
            }
        }
    }

    private void swap(List<Integer> data, int left, int right) {
        int temp = data.get(left);
        data.set(left,data.get(right));
        data.set(right,temp);
    }

}
