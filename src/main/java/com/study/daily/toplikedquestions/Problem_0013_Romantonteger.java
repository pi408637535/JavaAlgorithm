package com.study.daily.toplikedquestions;

import java.util.HashMap;
import java.util.Map;

public class Problem_0013_Romantonteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        if(n == 1){
            return map.get(s.charAt(0));
        }
        int res = 0;
        int i = 1;
        for(; i <= n-1; i++){
            if(map.get(s.charAt(i - 1)) < map.get(s.charAt(i))){
                res -= map.get(s.charAt(i-1));
            }else{
                res += map.get(s.charAt(i-1));
            }
        }
        res += map.get(s.charAt(i-1));
        return res;
    }

    public static void main(String[] args) {
        new Problem_0013_Romantonteger().romanToInt("III");
    }
}
