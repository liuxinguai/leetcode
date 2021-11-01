package com.github.leetcode.linked;

import org.junit.Test;

public class TwoLinkedTest {

    @Test
    public void testReservet() {
        TwoLinked<Integer> twoLinked = new TwoLinked<>(1);
        twoLinked.add(2).add(3).add(4);
        twoLinked.println();
        twoLinked.reverse();
        twoLinked.println();
        twoLinked.reverse2();
        twoLinked.println();
    }
}
