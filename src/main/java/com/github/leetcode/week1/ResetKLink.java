package com.github.leetcode.week1;

import lombok.AllArgsConstructor;

/**
 * @author xinguai.liu
 */
public class ResetKLink extends OneNodeOperator {

    public ResetKLink(Integer value) {
        super(value);
    }

    public ResetKLink(Node<Integer> head, Integer size) {
        super(head, size);
    }

    public void reset(Integer k) {
        if (k > size) {
            return;
        }
        Node<Integer> current = head;
        Node<Integer> newHead = head;
        Node<Integer> tail = null;
        while (current != null) {
            ResetInfo info = canReset(current, k);
            if (info.can) {
                Node<Integer>[] node = process(current, k);
                if (newHead == head) {
                    newHead = node[0];
                    tail = node[1];
                } else {
                    tail.next = node[0];
                    tail = node[1];
                }
            } else {
                tail.next = current;
                break;
            }
            current = info.next;
        }
        head = newHead;
    }

    /**
     * 返回是否反转，若能反转，返回下一个呆反转的头结点
     * @param node 反转头节点
     * @param k 反转节点数
     * @return 是否能反转信息
     */
    protected ResetInfo canReset(Node<Integer> node, int k) {
        int index = 0;
        while (node != null && index < k) {
            index++;
            node = node.next;
        }
        return new ResetInfo(index == k, node);
    }

    protected Node<Integer>[] process(Node<Integer> node, int k) {
        int index = 0;
        Node<Integer> prev = null;
        Node<Integer> tail = node;
        while (index < k){
            Node<Integer> next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            index++;
        }
        return new Node[]{prev,tail};
    }

    @AllArgsConstructor
    class ResetInfo {

        private boolean can;

        private Node<Integer> next;

    }


}
