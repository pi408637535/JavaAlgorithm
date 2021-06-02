package com.study.daily.toplikedquestions;

import java.util.*;

public class Interview_04_06 {
    private List<TreeNode> list = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         if(root == null){
             return null;
         }
         inOrder(root);
        Iterator<TreeNode> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() == p){
                break;
            }
        }
        if(iterator.hasNext()){
            return iterator.next();
        }else{
            return null;
        }

    }

    private void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            list.add(node);
            inOrder(node.right);
        }
    }


    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode preNode = null;

        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.add(node);
                node = node.left;
            }
            TreeNode  temp = stack.pop();
            if(preNode == null){
                preNode= temp;
            }else{
                if(preNode == p) {
                    return temp;
                }
                preNode = temp;
            }
            node = temp.right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;

        System.out.println(new Interview_04_06().inorderSuccessor2(treeNode2,treeNode1 ));

    }

}
