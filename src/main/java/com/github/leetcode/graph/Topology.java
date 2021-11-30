package com.github.leetcode.graph;

import java.util.*;

/**
 * 拓扑排序算法：将一个无环的有向图变为有序
 * @author liuxg
 */
public class Topology {

    public <V> List<Node<V>> getNoRelyNodes(Graph<V> graph) {
        //拓扑排序后的结点
        List<Node<V>> topologys = new ArrayList<>(graph.nodes.size());
        //没有入度的哈希表
        Queue<Node<V>> noInNodes = new LinkedList<>();
        Map<Node<V>,Integer> inMap = new HashMap<>(graph.nodes.size());
        //遍历依次将图中结点放入没有入度的队列中和有入度的哈希表中
        graph.nodes.values().forEach(node -> {
            if (node.in == 0) {
                noInNodes.add(node);
            } else {
                inMap.put(node, node.in);
            }
        });
        //依次弹出没有入度的结点
        while (!noInNodes.isEmpty()) {
            Node<V> curr = noInNodes.poll();
            topologys.add(curr);
            //查找出这个结点相连的边
            for (Edge<V> edge : curr.edges) {
                //将连接的边另一头结点的入度-1
                Node<V> toNode = edge.to;
                inMap.put(toNode, inMap.get(toNode) - 1);
                // 判断边中to结点的入度是否为0，若为0加入到队列中
                if (inMap.get(toNode) == 0) {
                    noInNodes.add(toNode);
                }
            }
        }
        return topologys;
    }

}
