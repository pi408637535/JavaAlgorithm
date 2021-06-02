package com.study.daily.toplikedquestions;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_0958_CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        TreeNode node = null;
        TreeNode left = null;
        TreeNode right = null;

        //左右子孩子是否为null
        boolean flag = false;

        while (!deque.isEmpty()){
            node = deque.poll();
            left = node.left;
            right = node.right;

            if( (right != null && left == null) || (flag && (left != null || right != null)) ){
                return false;
            }

            if(left != null){
                deque.add(left);
            }

            if(right != null){
                deque.add(right);
            }

            if(left == null || right == null){
                flag = true;
            }
        }

        return true;
    }
}
