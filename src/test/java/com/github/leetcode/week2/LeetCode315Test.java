package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.*;

public class LeetCode315Test extends TestCase {

    private List<Integer> data = null;

    @Override
    public void setUp() throws Exception {
        data = new ArrayList<>(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            data.add(random.nextInt(10));
        }
        System.out.println(data);
    }

    public void test() {
        LeetCode315 code315 = new LeetCode315();
        System.out.println(code315.find(data));
        int[] arr = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = data.get(i);
        }
        System.out.println(code315.countSmaller(arr));
    }

    @Override
    public void tearDown() throws Exception {
        System.out.println(data);
    }
}