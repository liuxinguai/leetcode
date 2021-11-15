package com.github.leetcode.graph;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author liuxg
 */
public class GraphTraverse {


    /**
     * 宽度优先遍历
     *  1.从图中任选一结点点为源结点
     *  2.从源节点出发依次按照宽度进队列，然后弹出
     *  3.每弹出一个结点，把该节点所有没有进过队列的邻接点放入队列
     *  4.直到队列为空
     * @param head 图中任意结点
     * @param consumer 处理图结点的函数
     * @param <V> 结点的值
     */
    protected <V> void breadth(Node<V> head, Consumer<Node<V>> consumer) {
        Queue<Node<V>> traverse = new LinkedList<>();
        Set<Node<V>> processed = new HashSet<>();
        traverse.add(head);
        while (!traverse.isEmpty()) {
            Node<V> poll = traverse.poll();
            if (!processed.contains(poll)) {
                processed.add(poll);
                consumer.accept(poll);
            }
            for (Node<V> node : poll.nextNodes) {
                if (!processed.contains(node)) {
                    traverse.add(node);
                }
            }
        }
    }

    /**
     * 深度优先遍历
     * 1.从图中任选一结点为源结点
     * 2.从源节点开始把结点按照深度放入栈中，然后弹出
     * 3.每弹出一个点，把该结点下一个没有进过栈的邻接点放入栈中
     * 4.直到栈空
     * @param head 图中任意结点
     * @param consumer 处理结点的函数
     * @param <V> 结点的值
     */
    protected <V> void depth(Node<V> head, Consumer<Node<V>> consumer) {
        Stack<Node<V>> stack = new Stack<>();
        Set<Node<V>> processed = new HashSet<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node<V> peek = stack.peek();
            if (!processed.contains(peek)) {
                processed.add(peek);
                consumer.accept(peek);
            }
            for (Node<V> node : peek.nextNodes) {
                if (!processed.contains(node)) {
                    stack.add(peek);
                    stack.add(node);
                    break;
                }
            }
        }
    }




}
