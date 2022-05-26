package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode1Test extends TestCase {

    private List<Integer> source;

    private int target = 0;

    @Override
    public void setUp() throws Exception {
        Random random = new Random();
        Set<Integer> sourceSet = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set(sourceSet,random);
        }
        source = sourceSet.stream().collect(Collectors.toList());
        target = random.nextInt(50);
        System.out.println(target);
        System.out.println(source);
    }

    private void set(Set<Integer> source, Random random) {
        while (true) {
            final int nextInt = random.nextInt(50);
            if (!source.contains(nextInt)) {
                source.add(nextInt);
                break;
            }
        }
    }

    public void testAnswer() {
        System.out.println(new LeetCode1().answer(source,target));
    }
}