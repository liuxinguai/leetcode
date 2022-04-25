package com.github.leetcode.week1;


import org.junit.Test;

import java.util.Random;

public class NodeIntersectDemo {

    private Random random = new Random();

    private NodeIntersect intersect1 = null;

    private NodeIntersect intersect2 = null;

    @Test
    public void test() {
        no(10,5);
        intersect1.println();
        intersect2.println();
        System.out.println(intersect1.intersect(intersect2));
        and(5,5);
        intersect1.println();
        intersect2.println();
        System.out.println(intersect1.intersect(intersect2));
        and(10,8);
        intersect2.println();
        intersect1.println();
        System.out.println(intersect1.intersect(intersect2));
    }


    private void no(int intersectSize1, int intersectSize2) {
        intersect1 = new NodeIntersect(1);
        for (int i = 0; i < intersectSize1; i++) {
            intersect1.add(random.nextInt(intersectSize1));
        }

        intersect2 = new NodeIntersect(1);
        for (int i = 0; i < intersectSize2; i++) {
            intersect2.add(random.nextInt(intersectSize2));
        }
    }

    private void and(int intersectSize1, int intersectSize2) {
        if (intersectSize1 == intersectSize2) {
            OneNodeOperator.Node<Integer> node = OneNodeOperator.newNode(1);
            intersect1 = new NodeIntersect(node,1);
            intersect2 = new NodeIntersect(node,1);
            for (int i = 0; i < intersectSize1; i++) {
                intersect1.add(random.nextInt(intersectSize1));
            }
        } else {
            int max = Math.max(intersectSize1,intersectSize2);
            int min = Math.min(intersectSize1,intersectSize2);
            OneNodeOperator.Node<Integer> node = OneNodeOperator.newNode(1);
            NodeIntersect tmp = new NodeIntersect(node,1);
            if (max == intersectSize1) {
                intersect1 = tmp;
            } else {
                intersect2 = tmp;
            }
            for (int i = max; i > 0; i--) {
                OneNodeOperator.Node<Integer> aReturn = tmp.addAndReturn(random.nextInt(max));
                if (i == min) {
                    if (intersect1 == null) {
                        intersect1 = new NodeIntersect(aReturn,1);
                    } else {
                        intersect2 = new NodeIntersect(aReturn, 1);
                    }
                }
            }
        }
    }

}
