package src.LeetCode;

import java.util.Arrays;

public class Leetcode1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        double res = 0;
        int count = 0;
        for (int i= (int) (n * 0.05);i <(int)(n * 0.95);i++) {
            res += arr[i];
            count++;
        }
        return res/count;
    }
}
