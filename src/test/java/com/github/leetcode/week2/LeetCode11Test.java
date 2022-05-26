package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetCode11Test extends TestCase {

    private List<Integer> source;

    @Override
    public void setUp() throws Exception {
        source = new ArrayList<>(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            source.add(random.nextInt(20));
        }
        System.out.println(source);
    }

    public void testMax() {
        System.out.println(new LeetCode11().max(source));
    }
}