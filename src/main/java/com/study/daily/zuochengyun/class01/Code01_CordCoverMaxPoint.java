package com.study.daily.zuochengyun.class01;

import java.util.Arrays;

public class Code01_CordCoverMaxPoint {

    public int maxPoint1(int[] arr, int len) {
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            int index =  binarySearch(arr, i, arr[i]- len);
            res = Math.max(res, i - index + 1);
        }
        return res;
    }

    public int binarySearch(int[] arr, int right, int value){
        int left = 0;

        while (left + 1 < right){
            int mid = (right + left) / 2;
            if(arr[mid] == value)
                right = mid;
            else if(arr[mid] > value){
                right = mid;
            }else{
                left = mid;
            }
        }
        if(arr[left] >= value)
            return left;
        else
            return right;
    }

    public int maxPoint2(int[] arr, int len) {
        int left = 0;
        int right = 0;
        int res = 1;
        while (right < arr.length){
            while (right < arr.length && arr[right] - arr[left] <= len)
                right++;
            res = Math.max(right - left, res);
            left += 1;
        }
        return res;
    }

//    public int maxPoint2(int[] arr, int L) {
//        int left = 0;
//        int right = 0;
//        int N = arr.length;
//        int max = 0;
//        while (left < N) {
//            while (right < N && arr[right] - arr[left] <= L) {
//                right++;
//            }
//            max = Math.max(max, right - (left++));
//        }
//        return max;
//    }

    // for test
    public static int[] generateArray(int len, int max) {
        int[] ans = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) (Math.random() * max);
        }
        Arrays.sort(ans);
        return ans;
    }

    // for test
    public static int test(int[] arr, int L) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= L) {
                pre--;
            }
            max = Math.max(max, i - pre);
        }
        return max;
    }




    public static void main(String[] args) {
//        int[] arr= {1, 3, 3, 4, 5, 6, 8, 8, 9};
//        int len = 2;
//        System.out.println(new Code01_CordCoverMaxPoint().maxPoint1(arr, len));
//        System.out.println(new Code01_CordCoverMaxPoint().maxPoint2(arr, len));

        int len = 9;
        int max = 10;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int L = (int) (Math.random() * max);
            int[] arr = generateArray(len, max);
            int ans1 = new Code01_CordCoverMaxPoint().maxPoint1(arr, L);
            int ans2 = new Code01_CordCoverMaxPoint().maxPoint2(arr, L);
            int ans3 = test(arr, L);
            if (ans1 != ans2 || ans2 != ans3) {
                System.out.println("oops!");
                break;
            }
        }

    }
}
