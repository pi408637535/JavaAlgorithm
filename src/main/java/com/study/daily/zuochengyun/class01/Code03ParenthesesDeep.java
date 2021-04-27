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

public class Code03ParenthesesDeep {

    public static int maxLength(String s){
        if(s == null || s.length() == 0)
            return 0;

        char[] chars = s.toCharArray();
        int[] f = new int[chars.length];
        int length = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(')
                f[i] = 0;
            else{
                if(i - f[i-1] - 1>= 0 && chars[i - f[i-1] - 1] == '(')
                    f[i] = f[i-1] + 2;
                else
                    f[i] = 0;

            }
            length = Math.max(length, f[i]);
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "(((()))))((((()))))";
        System.out.println(maxLength(s));
    }
}
