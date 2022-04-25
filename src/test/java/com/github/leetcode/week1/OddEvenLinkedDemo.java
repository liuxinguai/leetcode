package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

public class OddEvenLinkedDemo {

    private OddEvenLinked linked;

    @Before
    public void init() {
        linked = new OddEvenLinked(1);
        for (int i = 2; i < 8; i++) {
            linked.add(i);
        }
        linked.println();
    }

    @Test
    public void test() {
        linked.parse();
        linked.println();
    }

}
