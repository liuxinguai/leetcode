package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.*;

public class MergeArrTest extends TestCase {

    List<Integer> source = null;

    List<Integer> targe = null;

    @Override
    public void setUp() throws Exception {
        source = new ArrayList<>(10);
        targe = new ArrayList<>(20);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            source.add(random.nextInt(50));
            targe.add(random.nextInt(50));
        }
        Collections.sort(source);
        Collections.sort(targe);
        System.out.println(source);
        System.out.println(targe);
    }

    public void test() {
        new MergeArr().merge(source,targe);
    }

    @Override
    public void tearDown() throws Exception {
        System.out.println(source);
        System.out.println(targe);
    }
}