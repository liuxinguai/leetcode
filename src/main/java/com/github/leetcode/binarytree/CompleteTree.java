package com.github.leetcode.binarytree;

import lombok.AllArgsConstructor;

/**
 * 判断一个树是否为完全二叉树，可以采用树的后续遍历方式，依次判断当前节点：左子树为完全二叉树 and 右子树为完全二叉树  左子树的高度和右子树的高度差值小于或等于1,则该节点所在的树为完全二叉树
 * @author liuxg
 */
public class CompleteTree {


    public <V extends Comparable> boolean complete(Node<V> head) {
        return processor(head).completed;
    }



    protected <V extends Comparable> CompleteInfo processor(Node<V> head) {
        if (head == null) {
            return new CompleteInfo(0,true);
        }
        CompleteInfo leftResult = processor(head.left);
        CompleteInfo rightResult = processor(head.right);
        CompleteInfo completeInfo = new CompleteInfo(Math.max(leftResult.high,rightResult.high) + 1,leftResult.completed && rightResult.completed ? Math.abs(leftResult.high- rightResult.high) <= 1: false);
        return completeInfo;
    }

    @AllArgsConstructor
    static class CompleteInfo {

        /**
         * 树的高度
         */
        private int high;

        /**
         * 是否是完全二叉树
         */
        private boolean completed;

    }

}
