package com.github.leetcode.week2.sort;

import java.util.List;

public interface Sort<T extends Comparable<T>> {

    void sort(List<T> data);

}
