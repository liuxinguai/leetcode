package com.github.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 递归的方式实现二叉树的先、中、后序遍历
 * @author liuxg
 */
public class RecursionTraverse {


    /**
     * 递归实现二叉数遍历
     *  一个二叉数通过递归来依次访问二叉树的所有节点，则所有节点都会执行到如下三处位置:1,2,3
     * @param head 头节点
     * @param handle 节点处理器
     * @param <V> 二叉数节点值泛型
     */
    protected <V extends Comparable> void recursionTraverse(Node<V> head, RecursionHandle<V> handle) {
        //页节点的的左孩子点和右孩子节点都为null，即结束递归
        if (head == null) {
            return;
        }

        if (handle.type() == Type.WIDTH) {
            widthTraverse(head,handle);
            return;
        }

        // 1 此地处理node为先序遍历：先序遍历：每个子树先根节点，左子树在进行先序遍历，右子树进行先序遍历
        if (handle.type() == Type.START) {
            handle.handle(head);
        }
        recursionTraverse(head.left,handle);


        // 2 此地处理node为中序遍历：中序遍历：每个子树左子数进行中序遍历，根节点，右子树进行中序遍历
        if (handle.type() == Type.MIDDLE) {
            handle.handle(head);
        }
        recursionTraverse(head.right,handle);

        // 3 此地处理node为后序遍历：后序遍历：每个子树左子数进行后序遍历，右子树进行后序遍历，根节点
        if (handle.type() == Type.END) {
            handle.handle(head);
        }
    }


    /**
     * 采用队列的方式实现：宽度遍历二叉树
     * @param head 二叉树头节点
     * @param handle 处理节点node过程
     * @param <V> 节点值
     */
    private <V extends Comparable> void widthTraverse(Node<V> head,RecursionHandle<V> handle) {
        Queue<Node<V>> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node<V> node = queue.poll();
            handle.handle(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }



    /**
     * 先序遍历
     * @param head 二叉树头节点
     * @param <V> 二叉树泛型值
     */
    public <V extends Comparable> void reOrderPrintln(Node<V> head) {
        recursionTraverse(head, new RecursionHandle<V>() {
            @Override
            public void handle(Node<V> node) {
                System.out.println(node.value);
            }

            @Override
            public Type type() {
                return Type.START;
            }
        });
    }

    /**
     * 中序遍历
     * @param head 二叉树头节点
     * @param <V> 二叉树泛型值
     */
    public <V extends Comparable> void middleOrderPrintln(Node<V> head) {
        recursionTraverse(head, new RecursionHandle<V>() {
            @Override
            public void handle(Node<V> node) {
                System.out.println(node.value);
            }

            @Override
            public Type type() {
                return Type.MIDDLE;
            }
        });
    }

    /**
     * 后序遍历
     * @param head 二叉树头节点
     * @param <V> 二叉树泛型值
     */
    public <V extends Comparable> void lastOrderPrintln(Node<V> head) {
        recursionTraverse(head, new RecursionHandle<V>() {
            @Override
            public void handle(Node<V> node) {
                System.out.println(node.value);
            }

            @Override
            public Type type() {
                return Type.END;
            }
        });
    }


    /**
     * 宽度遍历
     * @param head 二叉树头节点
     * @param <V> 二叉树泛型值
     */
    public <V extends Comparable> void widthPrintln(Node<V> head) {
        recursionTraverse(head, new RecursionHandle<V>() {
            @Override
            public void handle(Node<V> node) {
                System.out.println(node.value);
            }

            @Override
            public Type type() {
                return Type.WIDTH;
            }
        });
    }


    interface RecursionHandle<V extends Comparable> {

        /**
         * 处理递归的节点
         * @param node 节点
         */
        void handle(Node<V> node);

        /**
         * 二叉树遍历类型
         * @return 二叉树遍历类型
         */
        Type type();

    }


    enum Type {
        /**
         *在递归的开始位置处理node
         */
        START,
        /**
         * 在递归的中间位置处理node
         */
        MIDDLE,
        /**
         * 在递归的末尾处理node
         */
        END,
        /**
         * 宽度优先遍历，使用队列实现不使用递归实现
         */
        WIDTH
    }



}
