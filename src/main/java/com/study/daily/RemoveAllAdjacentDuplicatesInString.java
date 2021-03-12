package com.study.daily;
import java.util.*;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {

        if ( !(S != null) ||   S.length() == 0){
            return "";
        }

       StringBuffer stringBuffer = new StringBuffer();

        int top = -1;
        for(int i = 0; i < S.length(); i ++){

            if (top >= 0 && stringBuffer.charAt(top) == S.charAt(i)){
                stringBuffer.deleteCharAt(top);
                top -= 1;
            }else{
                stringBuffer.append(S.charAt(i));
                top += 1;
            }

        }
        return stringBuffer.toString();

    }

    public static void main(String[] args) {
        String s ="abbaca";
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates(s));
    }
}
