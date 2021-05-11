package com.study.base.sort;

import java.util.Arrays;

public class InsertSort {
    public static void insert(int[] nums){
        int i = 1;
        while (i < nums.length){
            int j = i;
            while (j > 0){
                if(nums[j] < nums[j - 1]){
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
                j--;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,9,4,5,6,2,3,1};
        insert(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
