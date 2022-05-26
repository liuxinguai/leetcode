package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IndexArrayTest extends TestCase {

    List<Integer> data = null;

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
        IndexArray array = new IndexArray();
        System.out.println(array.index(data));
        Collections.sort(data);
        System.out.println(array.index(data));
    }

    @Override
    public void tearDown() throws Exception {
        System.out.println(data);
    }
}