package com.study.daily.zuochengyun.class01;

public class Code04_ColorLeftRight {
    public static int minPaint2(String s) {

        if(s == null || s.length()  < 2){
            return 0;
        }
        int right = 0;
        char[] chars = s.toCharArray();
        for(int i = s.length() - 1; i >= 0; i--)
            right = chars[i] == 'R'? right + 1: right;
        int res = right;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            left = chars[i] == 'G'? left + 1: left;
            right = chars[i] == 'R'? right - 1: right;
            res = Math.min(res, left + right);
        }
        return res;
    }

    public static int minPaint1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int rAll = 0;
        for (int i = 0; i < N; i++) {
            rAll += str[i] == 'R' ? 1 : 0;
        }
        int ans = rAll; // 如果数组所有的范围，都是右侧范围，都变成G
        int left = 0;
        for (int i = 0; i < N - 1; i++) { // 0..i 左侧 n-1..N-1
            left += str[i] == 'G' ? 1 : 0;
            rAll -= str[i] == 'R' ? 1 : 0;
            ans = Math.min(ans, left + rAll);
        }
        // 0...N-1 左全部 右无
        ans = Math.min(ans, left + (str[N - 1] == 'G' ? 1 : 0));
        return ans;
    }


    public static void main(String[] args) {
        String test = "GGGRGGG";
        System.out.println(minPaint1(test));
        System.out.println(minPaint2(test));
    }

}
