package com.github.leetcode.week2.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class MergeSort implements Sort<Integer> {

    @Override
    public void sort(List<Integer> data) {
        process(data,0,data.size() - 1);
    }

    protected void process(List<Integer> data, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(data,left,mid);
        process(data,mid + 1,right);
        merge(data, left, mid, right);
    }

    protected void merge(List<Integer> data,int left, int mid,int right) {
        List<Integer> help = new ArrayList<>(right - left + 1);
        int l = left,r = mid + 1;
        while (l <= mid && r <= right) {
            help.add(data.get(l) <= data.get(r) ? data.get(l++) :data.get(r++));
        }
        while (l <= mid) {
            help.add(data.get(l++));
        }
        while (r <= right) {
            help.add(data.get(r++));
        }
        for (int i = 0; i < help.size(); i++) {
            data.set(left++, help.get(i));
        }
    }

}
