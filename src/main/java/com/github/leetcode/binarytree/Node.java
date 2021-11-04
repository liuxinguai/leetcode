package com.github.leetcode.binarytree;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Node<V extends Comparable> {

    public V value;

    public Node<V> left;

    public Node<V> right;

}
