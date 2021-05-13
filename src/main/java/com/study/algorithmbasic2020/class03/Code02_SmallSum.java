package com.study.algorithmbasic2020.class03;

import java.util.Arrays;

/**
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和。例如：
 * 对于数组[1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
 */

public class Code02_SmallSum {
    public int mergeSort(int[] nums, int l, int r){
        if(l == r){
            return 0;
        }
//        int mid = (l + r) >> 1;
        int  mid = l + ((r - l) >> 1);
        return mergeSort(nums, l, mid)
        + mergeSort(nums, mid + 1, r)
        + merge_pi(nums, l, mid, r);
    }

    public int merge_pi(int[] nums, int L, int MID, int R){
        int[] res = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = MID + 1;
        int result = 0;
        while (p1 <= MID && p2 <= R){
            if(nums[p1] < nums[p2]){
                System.out.println(String.format("%d-%d",nums[p1], nums[p2]));
                result += nums[p1] * (R - p2 + 1);
                res[i++] = nums[p1++];
            }else{
                res[i++] = nums[p2++];
            }
        }
        while (p1 <= MID){
            res[i++] = nums[p1++];
        }
        while (p2 <= R){
            res[i++] = nums[p2++];
        }
        i = 0;
        for(int k = L; k <= R; k++){
            nums[k] = res[i++];
        }
        return result;
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) { // base case
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }


    public static void main(String[] args) {
//        int[] nums = {1,3,4,2,5};
//        int res =new Code02_SmallSum().mergeSort(nums, 0, nums.length - 1);
//        System.out.println(res);

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            new Code02_SmallSum().mergeSort(arr2, 0, arr2.length - 1);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
