package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class ResetLinkDemo {

    private Random random = new Random();

    private ResetLink link = null;

    @Before
    public void init() {
        link = new ResetLink(1);
        for (int i = 0; i < 10; i++) {
            link.add(random.nextInt(10));
        }
    }

    @Test
    public void testReset() {
        link.println();
        link.reset().println();
    }

    @Test
    public void testResetLink() {
        link.println();
        link.resetLink().println();
    }
}
