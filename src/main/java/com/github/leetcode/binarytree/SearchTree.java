package com.github.leetcode.binarytree;

import lombok.AllArgsConstructor;

/**
 * 搜索二叉树，即让一个二叉树按中序遍历的方式改为一个数组，且该数组为一个升序数组
 *
 * 或者采用套路的解法：将子树的节点根节点，划分成左右两个子树，若两个子树都为搜索二叉树，且左子树的最大值小于当前节点的值，右子树的最小值大于这个节点的值，则以该节点为根的子树为搜索二叉树，并得出这个树的最小值和最大值
 * @author liuxg
 */
public class SearchTree {


    @AllArgsConstructor
    class SearcheInfo<V extends Comparable> {

        protected V min;

        protected V max;

        protected boolean searched;

    }

    public <V extends Comparable> boolean search(Node<V> head) {
        return processor(head).searched;
    }

    protected <V extends Comparable> SearcheInfo<V> processor(Node<V> head) {
        if (head == null) {
            return null;
        }
        SearcheInfo<V> left = processor(head.left);
        SearcheInfo<V> right = processor(head.right);
        V max = head.value;
        V min = head.value;
        if (left != null) {
            max = head.value.compareTo(left.max) > 0 ? max : left.max;
            min = head.value.compareTo(left.min) < 0 ? min : left.min;
        }
        if (right != null) {
            max = head.value.compareTo(right.max) > 0 ? max : right.max;
            min = head.value.compareTo(right.min) < 0 ? min : right.min;
        }
        boolean searched = true;
        if (left != null && (!left.searched || left.max.compareTo(head.value) >= 0)) {
            searched = false;
        }
        if (right != null && (!right.searched || right.min.compareTo(head.value) <= 0)) {
            searched = false;
        }
        return new SearcheInfo<>(min,max,searched);
    }

    protected <V extends Comparable<?>> void traverse(Node<V> head,SearchTreeContext<V> context) {
        if (head == null) {
            return ;
        }
        if (context.traverseHandle.type() == Type.START) {
            context.traverseHandle.handle(head);
        }
        traverse(head.left, context);
        if (context.traverseHandle.type() == Type.MIDDLE) {
            context.traverseHandle.handle(head);
        }
        traverse(head.right, context);
        if (context.traverseHandle.type() == Type.END) {
            context.traverseHandle.handle(head);
        }
    }

    public <V extends Comparable> boolean isSearch(final Node<V> head) {
        final SearchTreeContext<V> context = new SearchTreeContext<>();
        context.isSearch = true;
        context.max = null;
        context.traverseHandle = new TraverseHandle<V>() {
            @Override
            public void handle(Node<V> node) {
                if (context.isSearch) {
                    if (context.max == null) {
                        context.max = node.value;
                    } else {
                        int compare = node.value.compareTo(context.max);
                        // 若当前节点小于它中序遍历的最后一个节点的最大值，该树不是一个搜索二叉数
                        if (compare < 0) {
                            context.isSearch = false;
                        } else {
                            //若当前节点大于它中序遍历的最后一个节点的最大值，则将中序遍历的最大值改为当前节点
                            context.max = node.value;
                        }
                    }
                }
            }

            @Override
            public SearchTreeContext<V> getContext() {
                return context;
            }

            @Override
            public Type type() {
                return Type.MIDDLE;
            }
        };
        traverse(head,context);
        return context.isSearch;
    }


    static class SearchTreeContext<V extends Comparable> {
        protected V max;
        protected boolean isSearch;
        protected TraverseHandle<V> traverseHandle;
    }


    interface TraverseHandle<V extends Comparable> {

        /**
         * 递归遍历二叉树时，遍历到的当前节点
         * @param node 节点
         */
        void handle(Node<V> node);

        /**
         * 二叉树搜索全局上下文
         * @return
         */
        SearchTreeContext<V> getContext();

        /**
         * 二叉树遍历的方式
         * @return
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
    }


}
