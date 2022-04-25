package com.github.leetcode.week1;

/**
 * @author xinguai.liu
 */
public class ResetRangeLink extends OneNodeOperator {

    public ResetRangeLink(Integer value) {
        super(value);
    }

    public ResetRangeLink(Node<Integer> head, Integer size) {
        super(head, size);
    }

    public ResetRangeLink resetRangeLink(int left, int right) {
        if (left > right || left < 1) {
            return this;
        }
        Node<Integer> current = head;
        Node<Integer> prev = current;
        //TODO 找到翻转的节点的上一个节点
        int index = 1;
        while (current != null && index < left) {
            prev = current;
            current = current.next;
            index++;
        }
        //TODO 开始翻转
        Node<Integer> resetStart = current;
        Node<Integer> resetTail = null;
        while (current != null && index < right) {
            Node<Integer> tmp = current.next;
            current.next = resetTail;
            resetTail = current;
            current = tmp;
            index++;
        }
        if (current != null) {
            Node<Integer> tmp = current.next;
            current.next = resetTail;
            resetTail = current;
            current = tmp;
        }
        Node<Integer> newHead;
        if (prev == resetStart) {
            prev.next = current;
            newHead = resetTail;
        } else {
            prev.next = resetTail;
            resetStart.next = current;
            newHead = head;
        }
        return new ResetRangeLink(newHead,size);
    }

}
