package com.github.leetcode.week1;


import org.junit.Before;
import org.junit.Test;

public class ReciprocalLinkDemoTest {

    private ReciprocalLink link;

    @Before
    public void init() {
        link = new ReciprocalLink(1);
        for (int i = 2; i < 20; i++) {
            link.add(i);
        }
        link.println();
    }

    @Test
    public void test() {
        link.reciprocal(3).println();
        link.println();
        link.reciprocal(10).println();
        link.reciprocal(5).println();
    }

}