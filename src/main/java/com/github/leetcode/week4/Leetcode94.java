package com.github.leetcode.week4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        processor(root,result);
        return result;
    }

    protected void processor(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        processor(root.left,result);
        result.add(root.val);
        processor(root.right,result);
    }



}
