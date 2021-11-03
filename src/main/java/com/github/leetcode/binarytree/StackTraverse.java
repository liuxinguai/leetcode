package com.github.leetcode.binarytree;

import java.util.Stack;

/**
 * @author liuxg
 */
public class StackTraverse {


    /**
     * 先序遍历：将二叉树中的每个节点依次压入栈中（压入的顺序：先根再右后左）
     * @param head 头节点
     * @param <V> 节点值
     */
    public <V> void reOrderTraverse(Node<V> head) {
        if (head == null) {
            return;
        }
        Stack<Node<V>> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node<V> node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    /**
     * 后续遍历：将二叉数中的每个节点依次压入栈中（压入的顺序为：先根再左再右），再依次将节点弹出，弹出时将节点压入另一个栈中
     * @param head 头节点
     * @param <V> 节点值
     */
    public <V> void lastTraverse(Node<V> head) {
        if (head == null) {
            return;
        }
        Stack<Node<V>> traverseStack = new Stack<>();
        traverseStack.add(head);
        Stack<Node<V>> printStack = new Stack<>();
        while (!traverseStack.isEmpty()) {
            Node<V> node = traverseStack.pop();
            printStack.add(node);
            if (node.left != null) {
                traverseStack.add(node.left);
            }
            if (node.right != null) {
                traverseStack.add(node.right);
            }
        }
        while (!printStack.isEmpty()) {
            System.out.println(printStack.pop().value);
        }
    }

    /**
     * 将二叉数中的每个子树的左边界依次压入栈中，然后在依次弹出，弹出就打印，在弹出时将右子树的每一个做边界都压入栈中，重复上一个动作
     * @param head 二叉数头节点
     * @param <V> 节点值
     */
    public <V> void middleTraverse(Node<V> head) {
        Stack<Node<V>> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }

    }

}
