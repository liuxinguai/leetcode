package com.github.leetcode.linked;

import org.junit.Test;

public class TwoLinkedIntersectTest {

    @Test
    public void testIntersect() {

        TwoLinkedIntersect.Node<Integer> head1 = new TwoLinkedIntersect.Node<>(1,null);
        TwoLinkedIntersect.Node<Integer> node1 = new TwoLinkedIntersect.Node<>(2,null);
        TwoLinkedIntersect.Node<Integer> node2 = new TwoLinkedIntersect.Node<>(3,null);
        TwoLinkedIntersect.Node<Integer> node3 = new TwoLinkedIntersect.Node<>(4,null);
        TwoLinkedIntersect.Node<Integer> node4 = new TwoLinkedIntersect.Node<>(5,null);
        TwoLinkedIntersect.Node<Integer> node5 = new TwoLinkedIntersect.Node<>(6,null);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        TwoLinkedIntersect.Node<Integer> head2 = new TwoLinkedIntersect.Node<>(1,null);
        TwoLinkedIntersect.Node<Integer> node11 = new TwoLinkedIntersect.Node<>(2,null);
        TwoLinkedIntersect.Node<Integer> node21 = new TwoLinkedIntersect.Node<>(3,null);
        TwoLinkedIntersect.Node<Integer> node31 = new TwoLinkedIntersect.Node<>(4,null);
        TwoLinkedIntersect.Node<Integer> node41 = new TwoLinkedIntersect.Node<>(5,null);
        TwoLinkedIntersect.Node<Integer> node51 = new TwoLinkedIntersect.Node<>(6,null);
        head2.next = node11;
        node11.next = node2;
//        node11.next = node3;
//        node11.next = node21;
//        node21.next = node31;
//        node31.next = node41;
//        node41.next = node51;
//        node51.next = node21;
        TwoLinkedIntersect intersect = new TwoLinkedIntersect();
        System.out.println(intersect.intersect(head1,head2));

    }

}
