package src.LeetCode;

public class Leetcode1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        // 直接暴力
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean has = false;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i]-arr2[j]) <= d){
                    has = true;
                }
            }
            if (!has) {
                res++;
            }
        }
        return res;
    }
}
