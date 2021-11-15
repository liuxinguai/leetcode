package com.github.leetcode.graph;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 图中边
 * @author liuxg
 */
@NoArgsConstructor
@AllArgsConstructor
public class Edge<V> {

    /**
     * 边的起始位置
     */
    protected Node<V> from;

    /**
     * 边的终止位置
     */
    protected Node<V> to;

    /**
     * 边的权重
     */
    protected Integer weight;

}
