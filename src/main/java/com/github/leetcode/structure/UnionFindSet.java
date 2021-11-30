package com.github.leetcode.structure;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class UnionFindSet<V> {

    /**节点*/
    private Map<V, Element<V>> elementMap = new HashMap<>();

    /**节点的父节点*/
    private Map<Element<V>, Element<V>> parentMap = new HashMap<>();

    /**集合头节点所拥有的节点数目*/
    private Map<Element<V>, Integer> collectionMap = new HashMap();

    public UnionFindSet(List<V> elements) {
        elements.forEach(element -> {
            Element<V> vElement = new Element<>(element);
            elementMap.put(element, vElement);
            parentMap.put(vElement, vElement);
            collectionMap.put(vElement, 1);
        });
    }

    public boolean isSameSet(V element1, V element2) {
        checkContains(element1);
        checkContains(element2);
        return findParent(elementMap.get(element1)) == findParent(elementMap.get(element2));
    }

    public void union(V element1, V element2) {
        checkContains(element1);
        checkContains(element2);
        Element<V> vElement1 = findParent(elementMap.get(element1));
        Element<V> vElement2 = findParent(elementMap.get(element2));
        if (vElement1 != vElement2) {
            Integer coll1 = collectionMap.get(vElement1);
            Integer coll2 = collectionMap.get(vElement2);
            Element<V> maxElement = coll1 >= coll2 ? vElement1 : vElement2;
            Element<V> minElement = coll1 >= coll2 ? vElement2 : vElement1;
            collectionMap.put(maxElement,coll1 + coll2);
            collectionMap.remove(minElement);
            parentMap.put(minElement,maxElement);
        }
    }

    protected Element<V> findParent(Element<V> element) {
        Stack<Element<V>> stack = new Stack<>();
        while (element != parentMap.get(element)) {
            stack.push(element);
            element = parentMap.get(element);
        }
        while (!stack.isEmpty()) {
            parentMap.put(stack.pop(),element);
        }
        return element;
    }

    protected void checkContains(V value) {
        if (!elementMap.containsKey(value)) {
            throw new RuntimeException("该元素未纳入并查集管理中");
        }
    }

    @AllArgsConstructor
    private static class Element<V> {

        private V value;

    }

}
