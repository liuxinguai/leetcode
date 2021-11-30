package com.github.leetcode.graph;

import java.util.*;

/**
 * @author liuxg
 */
public class Kruskal {


    class UnionFind<V> {

        protected Map<Node<V>, List<Node<V>>> nodeListMap;

        public UnionFind(Graph<V> graph) {
            this.nodeListMap = new HashMap<>(graph.nodes.size());
            graph.nodes.values().forEach(vNode -> {
                ArrayList list = new ArrayList<>();
                list.add(vNode);
                nodeListMap.put(vNode,list);
            });
        }

        private boolean isSameSet(Node<V> fromNode, Node<V> toNode) {
            return nodeListMap.get(fromNode) == nodeListMap.get(toNode);
        }

        private void union(Node<V> fromNode, Node<V> toNode) {
            List<Node<V>> toNodes = nodeListMap.get(toNode);
            List<Node<V>> fromNodes = nodeListMap.get(fromNode);
            for(Node node : toNodes) {
                fromNodes.add(node);
                nodeListMap.put(node,fromNodes);
            }
        }

        /**
         * 判断这条表是否为闭环，采用的是一种并差集方式，即通过查询这个from结点所在的结合和to结点所在结合是否相等
         *  若相等，则说明从from点到to点已有路径联通，若此时再选择则就形成闭环了
         * @param edge 边
         * @return 闭环的标志
         */
        public boolean isLoop(Edge<V> edge) {
            if (!isSameSet(edge.from,edge.to)) {
                union(edge.from, edge.to);
                return false;
            }
            return true;
        }
    }

    /**
     * kruskal算法是从图生成最小树的一种算法
     * @param graph 图
     * @param <V> 值
     * @return 最小生成树的路径
     */
    public <V> Set<Edge<V>> generalMinTree(Graph<V> graph) {
        Set<Edge<V>> kruskalEdgs = new HashSet<>(graph.edges.size());
        //将图中的所有边放入小根堆中
        PriorityQueue<Edge<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        UnionFind<V> unionFind = new UnionFind<>(graph);
        priorityQueue.addAll(graph.edges);
        while (!priorityQueue.isEmpty()) {
            //取出当前小根堆中最小的边
            Edge<V> poll = priorityQueue.poll();
            //判断当前图的结点中（未加上边）加上该边后会不会形成闭环
            if (!unionFind.isLoop(poll)) {
                kruskalEdgs.add(poll);
            }
        }
        return kruskalEdgs;
    }


}
