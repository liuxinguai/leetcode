package com.github.leetcode.week4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * @author xinguai.liu
 */
public class Leetcode297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        traverse(root,builder);
        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
    protected void traverse(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("None,");
            return;
        }
        builder.append(root.val).append(",");
        traverse(root.left,builder);
        traverse(root.right,builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return traverse(dataList);
    }

    protected TreeNode traverse(List<String> data) {
        if (data.get(0).equals("None")) {
            data.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        treeNode.left = traverse(data);
        treeNode.right = traverse(data);
        return treeNode;
    }

}
