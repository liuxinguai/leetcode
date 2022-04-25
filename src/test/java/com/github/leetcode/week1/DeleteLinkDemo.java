package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class DeleteLinkDemo {

    DeleteLink link = null;

    private int rand = -1;

    @Before
    public void init() {
        link = new DeleteLink(1);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randNext = random.nextInt(20);
            link.add(randNext);
            if (i == 10) {
                rand = randNext;
            }
        }
        link.println();
    }

    @Test
    public void test() {
        link.delete(rand);
        System.out.println("delete item : "+rand);
        link.println();
        link.delete(1);
        link.println();
    }
}
