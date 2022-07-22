package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcodemianshi1708 {
    // 超时
    public int bestSeqAtIndex(int[] height, int[] weight) {
        // 最长递减子序列
        int[][] arr = new int[height.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0]=height[i];
            arr[i][1] = weight[i];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0]-o1[0];
                }
                return o1[1]-o2[1];
            }
        });

        int[] dp = new int[height.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 0; i < height.length; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j][1] > arr[i][1] && arr[j][0] > arr[i][0]) {
                    dp[i] = Math.max( dp[i],dp[j]+1);
                    max = Math.max(max,dp[i]);
                }
                if (arr[j][0] == arr[i][0]) {
                    dp[i] = dp[j];
                    max = Math.max(max,dp[i]);
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcodemianshi1708 l = new Leetcodemianshi1708();
        System.out.println(l.bestSeqAtIndex(new int[]{65,70,56,75,60,68},new int[]{100,150,90,190,95,110}));
    }
}
