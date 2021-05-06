package com.study.daily.toplikedquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_0011_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r){
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l) );
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return res;
    }
}
