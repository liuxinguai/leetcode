package com.github.leetcode.week2.sort;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseTestCase extends TestCase {

    protected List<Integer> data = null;

    private int size = 10;

    public void setUp() {
        data = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data.add(random.nextInt(20));
        }
        System.out.println(data);
    }

    @Override
    public void tearDown() throws Exception {
        System.out.println(data);
    }
}
