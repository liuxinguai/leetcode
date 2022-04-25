package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;


public class RandomLinkDemo {

    private RandomLink link = null;

    @Before
    public void init() {
        link = new RandomLink(1);
        for (int i = 2; i < 21; i++) {
            link.add(i);
        }
        link.println();
    }

    @Test
    public void test() {
        link.copy1().println();
        link.copy2().println();
    }

}
