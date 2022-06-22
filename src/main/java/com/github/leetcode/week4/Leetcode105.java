package com.github.leetcode.week4;

import java.util.*;

/**
 * @author xinguai.liu
 */
public class Leetcode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return processor(preorder,inorder,0,preorder.length - 1,0,inorder.length - 1,indexMap);
    }


    public TreeNode processor(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right, Map<Integer,Integer> indexMap) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = processor(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1,indexMap);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = processor(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right,indexMap);
        return root;
    }

}
