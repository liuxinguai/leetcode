package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class LoopLinkDemo {

    Random random = new Random();

    private LoopLink link;

    @Before
    public void init() {
        OneNodeOperator.Node<Integer> newNode = LoopLink.newNode(1);
        OneNodeOperator.Node<Integer> head = newNode;
//        for (int i = 0; i < 20; i++) {
//            newNode.next = LoopLink.newNode(random.nextInt(20));
//            newNode = newNode.next;
//        }
        OneNodeOperator.Node<Integer> node13 = null;
        for (int i = 0; i < 20; i++) {
            newNode.next = LoopLink.newNode(random.nextInt(20));
            if (i == 12) {
                node13 = newNode.next;
            }
            newNode = newNode.next;
        }
        newNode.next = node13;
//        newNode.next = head;
        link = new LoopLink(head,20);
    }

    @Test
    public void test() {
        System.out.println(link.loop().value);
    }

}
