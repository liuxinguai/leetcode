package com.github.leetcode.linked;

import org.junit.Test;

/**
 * @author liuxg
 */
public class PatitionLinkedTest {


    @Test
    public void testSort2() {
        PatitionLinked<Integer> patitionLinked = new PatitionLinked<>(5);
        patitionLinked.add(2).add(1).add(3).add(4).add(5).add(5).add(7).add(9).add(10);
        patitionLinked.println();
        patitionLinked.sort2(5);
        patitionLinked.println();
    }

    @Test
    public void testSort() {
        PatitionLinked<Integer> patitionLinked = new PatitionLinked<>(5);
        patitionLinked.add(2).add(1).add(3).add(4).add(5).add(5).add(7).add(9).add(10);
        patitionLinked.println();
        patitionLinked.sort(2);
        patitionLinked.println();
    }

}
