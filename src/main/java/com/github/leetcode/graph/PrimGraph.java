package com.github.leetcode.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author liuxg
 */
public class PrimGraph {


    /**
     * prim算法是从图生成最小树的一种算法
     * @param graph 图
     * @param <V> 值
     * @return 最小生成树的路径
     */
    public <V> Set<Edge<V>> prim(Graph<V> graph) {
        //最小生成树的边
        Set<Edge<V>> primSet = new HashSet<>(graph.edges.size());
        //已参与到最小生成树中结点
        Set<Node<V>> nodeSet = new HashSet<>(graph.nodes.size());
        //小根堆，用于选择出已被选择的结点中所有相邻边中的最小边
        PriorityQueue<Edge<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        graph.nodes.values().forEach(node -> {
            //若该结点已被选中过，即已参与过最小生成树的算法，则不应该重新选举
            if (!nodeSet.contains(node)) {
                nodeSet.add(node);
                //将任意结点的所有边放入小根堆中
                priorityQueue.addAll(node.edges);
                //选择出所有边中的最小边（边中权重最小）
                while (!priorityQueue.isEmpty()) {
                    Edge<V> poll = priorityQueue.poll();
                    Node<V> toNode = poll.to;
                    //若这条边的to端结点已被选中过，则不应该重新参与prim生成树的算法中
                    if (!nodeSet.contains(toNode)) {
                        primSet.add(poll);
                        nodeSet.add(toNode);
                        primSet.addAll(toNode.edges);
                    }
                }
            }
        });
        return primSet;
    }

}
