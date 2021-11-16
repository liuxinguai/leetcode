package com.github.leetcode.graph;

import java.util.*;

/**
 * 单元最短路径算法: 从图中一个节点（该节点必须是实现已被选择过的），从该节点到图中任意节点的最小距离的算法
 * @author liuxg
 */
public class Dijkstra {


    public Map<Node,Integer> sort(Node root) {
        //图中所有节点到root节点的距离的集合
        Map<Node,Integer> distanceMap = new HashMap<>();
        distanceMap.put(root,0);
        Set<Node> selectNodes = new HashSet<>();
        //选择出图中离root节点距离最近的且未被选择过的节点
        Node minDistinceNode = getMinDistinceAndUnSelectNode(distanceMap, selectNodes);
        while (minDistinceNode != null) {
            //最短距离
            int distance = distanceMap.get(minDistinceNode);
            //将这个最短距离的点中所有的边关联的节点放入distanceMap中
            for (Object edge : minDistinceNode.edges) {
                Edge nodeEdge = (Edge) edge;
                if (!distanceMap.containsKey(nodeEdge.to)) {
                    distanceMap.put(nodeEdge.to,nodeEdge.weight);
                }
                //更新已知某个节点到root的最短距离
                distanceMap.put(nodeEdge.to,Math.min(distanceMap.get(nodeEdge.to),distance + nodeEdge.weight));
            }
            //标记这个节点已被选中过
            selectNodes.add(minDistinceNode);
            //重新选择最小距离且未被选中的节点
            minDistinceNode = getMinDistinceAndUnSelectNode(distanceMap,selectNodes);
        }
        return distanceMap;
    }

    /**
     * 选择出未做出决定的最小距离的节点
     * @param distance 所有已被选择的节点和距离
     * @param selectNode 已被选中的节点
     * @return 最小距离的节点
     */
    protected Node getMinDistinceAndUnSelectNode(Map<Node,Integer> distance, Set<Node> selectNode) {
        Node minNode = null;
        int weight = Integer.MAX_VALUE;
        for (Map.Entry<Node,Integer> entry : distance.entrySet()) {
            if (!selectNode.contains(entry.getKey()) && weight > entry.getValue()) {
                weight = entry.getValue();
                minNode = entry.getKey();
            }
        }
        return minNode;
    }

}
