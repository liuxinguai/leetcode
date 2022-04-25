package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class ResetRangeLinkDemo {

    private Random random = new Random();

    private ResetRangeLink link = null;

    @Before
    public void init() {
        link = new ResetRangeLink(1);
        for (int i = 0; i < 9; i++) {
            link.add(random.nextInt(10));
        }
        link.println();
    }

    @Test
    public void test() {
        link.resetRangeLink(1,11).println();
    }
}
