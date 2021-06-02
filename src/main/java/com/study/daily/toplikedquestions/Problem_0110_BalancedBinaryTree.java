package com.study.daily.toplikedquestions;

public class Problem_0110_BalancedBinaryTree {
    class ReturnType{
        private Integer height;
        private Boolean balance;

        public ReturnType(Integer height, Boolean balance) {
            this.height = height;
            this.balance = balance;
        }
    }

    private ReturnType helper(TreeNode node){
        if(node == null){
            return new ReturnType(0, true);
        }

        ReturnType leftRes = helper(node.left);
        ReturnType rightRes = helper(node.right);

        boolean balance = Math.abs(leftRes.height - rightRes.height) <= 1 &&  leftRes.balance
                && rightRes.balance ? true : false;
        return new ReturnType(Math.max(leftRes.height, rightRes.height) + 1, balance);

    }

    public boolean isBalanced(TreeNode root) {
        ReturnType res = helper(root);
        return res.balance;
    }
}
