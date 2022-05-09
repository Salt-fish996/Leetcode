package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode2008 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        // 使用dp[i]表示以i结尾的最大盈利
        Arrays.sort(rides, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        long[] dp = new long[rides.length];
        long[] dpMax = new long[rides.length]; // 记录前i位的最大值
        for (int i = 0; i < rides.length; i++) {

            for (int j = i-1; j >= 0; j--) {
                if (rides[j][1] <= rides[i][0]) {
                    dp[i] = dpMax[j];
                    break;
                }
            }
            dp[i] += rides[i][1]-rides[i][0]+rides[i][2];
            dpMax[i] = Math.max(i>0?dpMax[i-1]:0,dp[i]);
        }
        return dpMax[rides.length-1];
    }

    public static void main(String[] args) {
        Leetcode2008 l = new Leetcode2008();
        System.out.println();
    }
}
