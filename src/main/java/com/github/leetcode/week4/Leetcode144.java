package com.github.leetcode.week4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        processor(root,result);
        return result;
    }

    protected void processor(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        processor(root.left,result);
        processor(root.right,result);
    }


}
