package com.study.daily.toplikedquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_0162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int l = 0;
        int r = nums.length -1;
        while (l + 1 < r){
            int mid = (l + r) / 2;
            if( nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1] ){
                l = mid;
            }else if (nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(l == 0 && nums[l] > nums[l+1]){
            return l;
        }else if(r == nums.length - 1 && nums[r] > nums[r - 1]){
            return r;
        }else if( nums[l] > nums[l - 1] && nums[l] > nums[l + 1]){
            return l;
        }else{
            return r;
        }

    }


}
