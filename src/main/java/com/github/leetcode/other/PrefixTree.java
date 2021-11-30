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
        if (checkWord(word)) {
            return;
        }
        char[] array = word.toCharArray();
        Node node = head;
        node.pass ++;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            Node newNode = null;
            if (node.nexts[index] == null) {
                node.nexts[index] = new Node();
            }
            newNode = node.nexts[index];
            newNode.pass++;
            node = newNode;
        }
        node.end++;
    }

    public int search(String word) {
        Node node = searchNode(word);
        return node == null ? -1 : node.end;
    }

    public int searchPrex(String word) {
        Node node = searchNode(word);
        return node == null ? -1 : node.pass;
    }

    public void delete(String word) {
        if (checkWord(word)) {
            return ;
        }
        if (search(word) > 0) {
            char[] chars = word.toCharArray();
            Node node = head;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                node.nexts[index].pass --;
                if (i == chars.length - 1 && -- node.nexts[index].end == 0) {
                    node.nexts[index] = null;
                    continue;
                }
                node = node.nexts[index];
            }
        }
    }

    private boolean checkWord(String word) {
        return word == null || word.trim().equals("") ? true : false;
    }

    protected Node searchNode(String word) {
        if (checkWord(word)) {
            return null;
        }
        char[] chars = word.toCharArray();
        Node node = head;
        for (char proChar : chars) {
            int index = proChar - 'a';
            if (node.nexts[index] == null) {
                return null;
            }
            node = node.nexts[index];
        }
        return node;
    }

}
