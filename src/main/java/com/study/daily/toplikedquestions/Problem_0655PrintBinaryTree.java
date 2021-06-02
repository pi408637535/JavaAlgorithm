package com.study.daily.toplikedquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_0655PrintBinaryTree {

    int treeHeight(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int left = treeHeight(root.left);
            int right = treeHeight(root.right);
            return Math.max(left, right) + 1;
        }
    }

    void helper(String[][] res, TreeNode node, int i, int l , int r){
        if(node != null){
            res[i][(l + r) / 2] = "" + node.val;
            helper(res, node.left, i + 1, l, (l + r) / 2);
            helper(res, node.right, i + 1, (l + r + 1) / 2, r);
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }


        int rows = treeHeight(root);
        int columns = (1 << rows) - 1;
        String[][] res = new String[rows][columns];

        for(String[] arr: res){
            Arrays.fill(arr, "");
        }

        helper(res, root, 0, 0, columns);
        List<List<String>> ans = new ArrayList<>();
        for(String[] arr:res){
            ans.add(Arrays.asList(arr));
        }
        return ans;
    }
}
