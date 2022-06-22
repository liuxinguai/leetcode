package com.github.leetcode.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class Leetcode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        processor(root, result);
        return result;
    }

    protected void processor(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        processor(root.left,result);
        processor(root.right,result);
        result.add(root.val);
    }

}
