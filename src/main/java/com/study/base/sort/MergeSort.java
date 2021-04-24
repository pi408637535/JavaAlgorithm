package com.study.base.sort;

import java.util.Arrays;

public class MergeSort {

    public void Sort(int[] nums, int l, int r){
        if(l == r)
            return;
        int mid = (l + r) >> 1;
        Sort(nums, l, mid);
        Sort(nums, mid + 1, r);
        Merge(nums, l, mid, r);
    }

    public void Merge(int[] nums, int L, int MID, int R){
        int[] helper = new int[L + R+1];
        int i = 0;
        int p1 = L;
        int p2 = MID+ 1;
        while (p1 <= MID && p2 <= R){
            helper[i++] = nums[p1] < nums[p2]? nums[p1++]: nums[p2++];
        }
        while (p1 <=  MID)
            helper[i++] = nums[p1++];
        while (p2 <= R )
            helper[i++] = nums[p2++];
        i = 0;
        for(int k = L; k <= R;){
            nums[k++] = helper[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,7,5,6,4,1,2,3};
        new MergeSort().Sort(nums, 0, nums.length-1);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
