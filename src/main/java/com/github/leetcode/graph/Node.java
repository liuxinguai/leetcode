package com.github.leetcode.graph;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 图中的结点
 * @author liuxg
 */
@NoArgsConstructor
@AllArgsConstructor
public class Node<V> {

    /**
     * 图中结点表示的值
     */
    protected V value;

    /**
     * 结点的入度
     */
    protected Integer in;

    /**
     * 结点的出度
     */
    protected Integer out;

    /**
     * 结点相连接的边
     */
    protected List<Edge<V>> edges;

    /**
     * 相邻的结点
     */
    protected List<Node<V>> nextNodes;

}
