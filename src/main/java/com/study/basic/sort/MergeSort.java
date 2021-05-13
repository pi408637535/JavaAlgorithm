package com.study.basic.sort;

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

    public void Sort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }

        int mergeSize = 1;
        int N = nums.length;
        while (mergeSize < N){
            int l = 0;
            while (l < N){
                int mid = l + mergeSize - 1;
                if(mid > N)
                    break;
                int r = Math.min( mid + mergeSize, N - 1);
                Merge(nums, l, mid, r);
                l = r + 1;
            }
            if(mergeSize > N / 2)
                break;
            mergeSize = mergeSize << 1;
        }

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

    //Todo mergeSort非递归版
    //算法基础3，在看是已经能理解很多


    public static void main(String[] args) {
        int[] nums = {8,7,5,6,4,1,2,3};
//        new MergeSort().Sort(nums, 0, nums.length-1);
        new MergeSort().Sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
