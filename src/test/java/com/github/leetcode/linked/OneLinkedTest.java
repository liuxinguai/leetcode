package com.github.leetcode.linked;

import org.junit.Test;

import java.util.Stack;

public class OneLinkedTest {

    @Test
    public void testReservet() {
        OneLinked<Integer> oneLinked = new OneLinked<>(1);
        oneLinked.add(2).add(3).add(4).add(5).add(6);
        oneLinked.println();
        oneLinked.reverse();
        oneLinked.println();
        oneLinked.reverse2();
        oneLinked.println();
    }
}
