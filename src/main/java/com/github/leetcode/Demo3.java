package com.github.leetcode;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class Demo3 {

    public static void main(String[] args) {
        final int[] values = { 1, 3, 4, 5, 2, 8, 6, 7, 9, 0 };
        System.out.println("Create BST: ");
        Node root = createBinaryTree(values);

        System.out.println("Traversing the BST with recursive algorithm: ");
        inOrderTransvalWithRecursive(root);

        System.out.println("Traversing the BST with iterative algorithm: ");
        inOrderTransvalWithIterate(root);
    }

    public static Node createBinaryTree(int[] values) {
        // TODO: 二叉搜索树特点：
        /**
         * 若它的左子树不为空，则左子树上的所有结点都小于根节点上的值
         * 若它的右子树不为空，则右子树上的所有结点都大于根节点上的值
         * 它的左右子树也分别是二叉搜索树
         */
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < values.length; i++) {
            binaryTree.insert(values[i]);
        }
        return binaryTree.root();
    }

    // 递归实现
    public static void inOrderTransvalWithRecursive(Node node) {
        // TODO: 中序 先递归访问左子树 再访问根结点 最后递归访问右子树
        if (node == null) {
            return;
        }
        inOrderTransvalWithRecursive(node.left);
        System.out.println(node.value);
        inOrderTransvalWithRecursive(node.right);
    }

    // 非递归实现
    public static void inOrderTransvalWithIterate(Node root) {
        // TODO: 依次将二叉树中的左子树压入栈中，再弹出左子树上的节点时将右子树的节点押入栈中
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.value);
                root = root.right;
            }
        }
    }

    static class BinaryTree {

        Node root;

        public void insert(int value) {
            Node node = new Node(value,null,null);
            if (root == null) {
                root = node;
                return;
            }
            Node curr = root;
            Node parent = null;
            while (curr != null) {
                parent = curr;
                if(curr.value > node.value) {
                    curr = curr.left;
                } else if(curr.value < node.value) {
                    curr = curr.right;
                } else {
                    throw new IllegalArgumentException("该树咋在二叉树中有值");
                }
            }
            if (parent.value > node.value) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        public Node root() {
            return root;
        }

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Node {
        int value;

        Node left;

        Node right;
    }

}
