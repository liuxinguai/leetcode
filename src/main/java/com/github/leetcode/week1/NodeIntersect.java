package com.github.leetcode.week1;


/**
 * @author xinguai.liu
 */
public class NodeIntersect extends OneNodeOperator {

    public NodeIntersect(Integer value) {
        super(value);
    }

    public NodeIntersect(Node<Integer> head, Integer size) {
        super(head,size);
    }

    public Integer intersect(NodeIntersect other) {
        if (other.size.intValue() == this.size.intValue()) {
            return other.head == this.head ? head.value : null;
        }
        Node<Integer> maxNode = this.size == Math.max(this.size,other.size) ? this.head : other.head;
        Node<Integer> minNode = this.size == Math.min(this.size,other.size) ? this.head : other.head;
        while (maxNode != null) {
            if (maxNode == minNode) {
                return maxNode.value;
            }
            maxNode = maxNode.next;
        }
        return null;
    }



}
