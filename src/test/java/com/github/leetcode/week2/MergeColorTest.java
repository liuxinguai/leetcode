package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeColorTest extends TestCase {

    private List<Integer> data;

    @Override
    public void setUp() throws Exception {
        data = new ArrayList<>(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            data.add(random.nextInt(3));
        }
        System.out.println(data);
    }

    public void test() {
        new MergeColor().merge(data);
    }

    @Override
    public void tearDown() throws Exception {
        System.out.println(data);
    }
}