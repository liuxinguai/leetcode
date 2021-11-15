package com.github.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * @author liuxg
 */
public abstract class Graph<V> {

    protected Map<V,Node<V>> nodes;

    protected Set<Edge<V>> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    public static <R,V> Graph<V> build(Function<R,Graph<V>> function, R r) {
        return function.apply(r);
    }

}
