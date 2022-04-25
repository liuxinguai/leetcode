package com.github.leetcode.week2.sort;

import java.util.List;

/**
 * @author xinguai.liu
 */
public class QuickSort implements Sort<Integer> {


    @Override
    public void sort(List<Integer> data) {
        processor(data,0,data.size() - 1);
    }

    protected void processor(List<Integer> data, int left, int right) {
        if (left < right) {
            swap(data, left + (int)Math.random() * (right - left +1),right);
            int[] partition = doProcessor(data, left, right);
            processor(data,left,partition[0] -1);
            processor(data,partition[1] + 1,right);
        }
    }


    protected int[] doProcessor(List<Integer> data, int left, int right) {
        int leftIndex = left - 1;
        int rightIndex = right;
        while (left < rightIndex) {
            if (data.get(left) < data.get(right)) {
                swap(data, ++leftIndex, left++);
            } else if (data.get(left) == data.get(right)) {
                left++;
            } else if (data.get(left) > data.get(right)){
                swap(data, left, --rightIndex);
            }
        }
        swap(data,rightIndex,right);
        return new int[] {leftIndex + 1, rightIndex};
    }

    private void swap(List<Integer> data, int left, int right) {
        int temp = data.get(left);
        data.set(left,data.get(right));
        data.set(right,temp);
    }

}
