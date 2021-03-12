package com.study.daily;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int number = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                continue;
            }else if(Character.isDigit(s.charAt(i))){
                number = number * 10 + s.charAt(i) - '0';
            }else if (s.charAt(i) == '+'){
                number *= sign;
                res += number;

                number = 0;
                sign = 1;
            }else if (s.charAt(i) == '-'){
                number *= sign;
                res += number;

                number = 0;
                sign = -1;
            }else if(s.charAt(i) == '('){
                stack.add(res);
                stack.push(sign);

                number = 0;
                sign = 1;
                res = 0;
            }else{
                number *= sign;
                res += number;

                res *= stack.pop();
                res += stack.pop();
                number = 0;
            }
        }
        if(number != 0){
            number *= sign;
            res += number;
        }
        return res;

    }

    public static void main(String[] args) {
//        String s = "1-1";
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new BasicCalculator().calculate(s));
    }
}
