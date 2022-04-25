package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class AscMergeDemo {

    private AscMerge merge1;

    private AscMerge merge2;

    private Random random = new Random();

    @Before
    public void init() {
        merge1 = new AscMerge(random.nextInt(10));
        merge2 = new AscMerge(random.nextInt(10));
        for (int i = 0; i < 10; i++) {
            merge2.add(random.nextInt(100));
            merge1.add(random.nextInt(100));
        }
        merge1.println();
        merge2.println();
    }

    @Test
    public void test() {
        merge1.merge(merge2).println();
    }

}
