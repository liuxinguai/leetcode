package com.github.leetcode.other;

import java.util.Locale;

/**
 * @author liuxg
 */
public class PrefixTree {

    private Node head = new Node();

    class Node {

        protected int pass;

        protected int end;

        protected Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            nexts = new Node[26];
        }
    }

    public void insert(String word) {
        if (word == null || word.trim().equals("")) {
            return;
        }
        char[] array = word.toCharArray();
        Node node = head;
        node.pass ++;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            Node newNode = null;
            if (node.nexts[index] == null) {
                newNode = new Node();
            }
            newNode.pass++;
            node = newNode;
        }
        node.end++;
    }

    public int search(String word) {
        if (word == null || word.trim().equals("")) {
            return -1;
        }
        char[] chars = word.toCharArray();
        Node node = head;
        for (char proChar : chars) {
            int index = proChar-'a';
            if (node.nexts[index] == null) {
                return -1;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    public int searchPrex(String word) {
        if (word == null || word.trim().equals("")) {
            return -1;
        }
        char[] chars = word.toCharArray();
        Node node = head;
        for (char proChar : chars) {
            int index = proChar-'a';
            if (node.nexts[index] == null) {
                return -1;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    public void delete(String word) {
        if (word == null || word.trim().equals("")) {
            return ;
        }
        if (search(word) > 0) {
            char[] chars = word.toCharArray();
            Node node = head;
            for (char proChar : chars) {
                int index = proChar-'a';
                if (-- node.nexts[index].end == 0) {
                    node.nexts[index] = null;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

}
