package com.study.daily.toplikedquestions;


public class Problem_0014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String original = strs[0];
        for(int i = 0; i < original.length(); i++){

            for(String str: strs){
                if(i < str.length()){
                    if(! original.substring(0, i+1).equals(str.substring(0,i+1))){
                        return original.substring(0,i).length() == 0? "":original.substring(0,i);
                    }
                }else{
                    return original.substring(0,i).length() == 0? "":original.substring(0,i);
                }
            }
        }
        return original;
    }

    //方法二可以，考虑逐个遍历，找最小公约

    public static void main(String[] args) {
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
        String[] strs = {"ab", "a"};
//        System.out.println("ab".substring(0,2));
        System.out.println(new Problem_0014_LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
