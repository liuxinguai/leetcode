package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class ResetKLinkDemo {

    private ResetKLink link;

    @Before
    public void init() {
        link = new ResetKLink(1);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            link.add(random.nextInt(20));
        }
        link.println();
    }

    @Test
    public void test() {
        link.reset(3);
        link.println();
    }
}
