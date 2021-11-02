package com.github.leetcode.linked;

import org.junit.Test;

import java.util.Random;

public class CopyRandomLinkedTest {

    @Test
    public void testRandom() {
        CopyRandomLinked<Integer> copyRandomLinked = new CopyRandomLinked<>(3);
        copyRandomLinked.add(4).add(5).add(6).add(7).add(8).add(9).add(11).add(12).add(13);
        copyRandomLinked.println();
        copyRandomLinked.random();
        copyRandomLinked.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        CopyRandomLinked<Integer> linked = copyRandomLinked.copy2();
        linked.println();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        linked = copyRandomLinked.copy();
        linked.println();
    }


}
