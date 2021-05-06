package com.study.daily.toplikedquestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
         int index = 0;
        for(int i = 0; i < nums.length; i++){
            int res = target - nums[i];
            if(!hashMap.containsKey(res)){
                hashMap.put(nums[i], i);
            }else{
                index = i;
                break;
            }

        }
        return new int[]{index, hashMap.get(target - nums[index])};
    }

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9;

        int[] nums = {3,2,4};
        int target = 6;

        int[] res = new Problem_0001_TwoSum().twoSum(nums, target);
        Arrays.stream(res).forEach(System.out::println);
    }
}
