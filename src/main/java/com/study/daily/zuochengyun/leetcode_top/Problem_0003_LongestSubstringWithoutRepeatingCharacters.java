package com.study.daily.zuochengyun.leetcode_top;

import java.util.HashMap;
import java.util.Map;

public class Problem_0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1)
            return 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] f = new int[n];
        Map<Character, Integer> map = new HashMap<>();
        f[0] = 1;
        map.put(chars[0], 0);
        int maxLength = 1;
        for(int i = 1; i < n; i++){
            f[i] = Math.min(f[i - 1] + 1, i - map.getOrDefault(chars[i], -1));
            maxLength = Math.max(maxLength, f[i]);
            map.put(chars[i], i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Problem_0003_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
