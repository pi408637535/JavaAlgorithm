package com.study.daily.toplikedquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_0015_3Sum {
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                List<List<Integer>> nexts = twoSum1(nums, i + 1, -nums[i]);
                for (List<Integer> cur : nexts) {
                    cur.add(0, nums[i]);
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> twoSum1(int[] nums, int begin, int target) {
        int L = begin;
        int R = nums.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while (L < R) {
            if (nums[L] + nums[R] > target) {
                R--;
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                if (L == begin || nums[L - 1] != nums[L]) {                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Problem_0015_3Sum.threeSum1(nums);
    }
}
