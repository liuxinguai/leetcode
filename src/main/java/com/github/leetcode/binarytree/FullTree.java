package com.github.leetcode.binarytree;

import lombok.AllArgsConstructor;

/**
 * 判断一个树是否为满二叉树：
 *  解体套路：
 *      将这个树拆分成左子树和右子树，该树的整节点数 = 左子树的节点数 + 右子树的节点数 + 1;该数的高度 = max(左子树的高度，右子树的高度) + 1；
 *      最后整个树满足：该树的节点数 = 2 ^ 树高度 - 1
 * @author liuxg
 */
public class FullTree {

    @AllArgsConstructor
    class FullInfo {
        /**
         * 树的节点数
         */
        private int nodeNum;
        /**
         * 树的高度
         */
        private int high;
    }

    @AllArgsConstructor
    class FullInfo2 {

        private boolean isFull;

        private int high;

    }

    public <V extends Comparable> boolean full2(Node<V> head) {
        return processor2(head).isFull;
    }

    protected  <V extends Comparable> FullInfo2 processor2(Node<V> head) {
        if (head == null) {
            return new FullInfo2(true,0);
        }
        FullInfo2 left = processor2(head.left);
        FullInfo2 right = processor2(head.right);
        return new FullInfo2(left.isFull && right.isFull && left.high == right.high, left.high + 1);
    }

    public <V extends Comparable> boolean full1(Node<V> head) {
        FullInfo fullInfo = processor1(head);
        return fullInfo.nodeNum == ((1 << fullInfo.high ) - 1);
    }

    protected <V extends Comparable> FullInfo processor1(Node<V> head) {
        if (head == null) {
            return new FullInfo(0,0);
        }
        FullInfo left = processor1(head.left);
        FullInfo right = processor1(head.right);
        return new FullInfo(left.nodeNum+ right.nodeNum+1,Math.max(left.high, right.high) + 1);
    }

}
