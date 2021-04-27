package com.study.daily;

import java.util.Arrays;

public class SmallSum {

    public int smallSum(int[] arr){
        if(arr == null)
            return 0;
        if(arr.length < 2)
            return arr[0];

        return process(arr, 0, arr.length - 1);
    }

    public int process(int[] arr, int L, int R){
        if(L == R)
            return 0;
        int mid = (L + R) / 2;
        return process(arr, L, mid) +
        process(arr, mid + 1, R) +
         merge(arr, L, mid, R);
    }

    public int merge(int []arr, int L, int M, int R){
        int res = 0;
        int p1 = L;
        int p2 = M + 1;
        int[] helper = new int[L + R + 1];
        int i = 0;
        while (p1 <= M && p2 <= R){
            if(arr[p1] < arr[p2]){
                res += arr[p1];
                helper[i++] = arr[p1++];
            }else{
                helper[i++] = arr[p2++];
            }

        }
        while (p1 <= M){
            helper[i++] = arr[p1++];
        }
        while (p2 <= R){
            helper[i++] = arr[p2++];
        }

        i = 0;
        for(int k = L; k <= R; ){
            arr[k++] = helper[i++];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,4,2,5};
        //new SmallSum().process(arr, 0, arr.length - 1);
        System.out.println(new SmallSum().smallSum(arr));
        //Arrays.stream(arr).forEach(System.out::println);
    }
}
