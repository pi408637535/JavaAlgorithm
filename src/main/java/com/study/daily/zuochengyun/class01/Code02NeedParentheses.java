package com.study.daily.zuochengyun.class01;

/**
 * 括号有效配对是指：
 * 1）任何一个左括号都能找到和其正确配对的右括号
 * 2）任何一个右括号都能找到和其正确配对的左括号
 * 有效的：    (())  ()()   (()())  等
 * 无效的：     (()   )(     等
 * 问题一：怎么判断一个括号字符串有效？
 * 问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
 *
 */
public class Code02NeedParentheses {

    public boolean judgeValid(String s){
        char[] chars =  s.toCharArray();

        /**
         * 思路:遇到左括号+1，遇到右边括号-1，如果count在遍历过程为负，说明右括号已经超过了左括号
         */
        int count = 0;
        for(char c:chars){
            if(c == '(')
                count++;
            else
                count--;
            if(count < 0)
                return false;
        }
        if(count == 0)
            return true;
        else
            return false;
    }

    public static int needParentheses(String s) {
        int count = 0; //记录多余的左括号
        int need = 0; //记录需要被多消除的右括号
        /**
         * need用于记录，超过匹配的')'括号。
         * 算法思路:当右括号')'超过匹配量是(count < 0情况),need++,同时count置为0
         */
        char[] chars =  s.toCharArray();
        for(char c:chars){
            if(c == '(')
                count++;
            else {
                count = 0;
                need ++;
            }
        }
        /**
         * count的作用与judgeValid count相同
         */
        return count+need;

    }
}
