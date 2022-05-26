package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.*;

public class LeetCode977Test extends TestCase {

    private List<Integer> source;

    @Override
    public void setUp() throws Exception {
        source = new ArrayList<>(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int anInt = random.nextInt(20);
            if (anInt % 2 == 0) {
                source.add(anInt);
            } else {
                source.add(anInt * -1);
            }
        }
        Collections.sort(source);
        System.out.println(source);
    }

    public void testSquare() {
        final LeetCode977 code977 = new LeetCode977();
        final List<Integer> square = code977.square(source);
        System.out.println(square);
    }



}