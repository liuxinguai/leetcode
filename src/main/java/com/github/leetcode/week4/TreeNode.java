package com.github.leetcode.week4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }


}
