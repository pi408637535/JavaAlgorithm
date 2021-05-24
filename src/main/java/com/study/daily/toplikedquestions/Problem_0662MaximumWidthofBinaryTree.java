package com.study.daily.toplikedquestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem_0662MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);

        int preLevel = 0;
        int curLevel = 1;
        int maxWidth = 0;
        int curWidth = 0;

        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            curLevel = map.get(temp);
            if(temp.left != null){
                map.put(temp.left, curLevel + 1);
            }
            if(temp.right != null){
                map.put(temp.right, curLevel + 1);
            }
            if(curLevel != preLevel){
                preLevel = curLevel;
                curLevel = 1;
            }else{
                curLevel++;
                maxWidth = Math.max(curWidth, maxWidth);
            }
        }

        return maxWidth;
    }

}
