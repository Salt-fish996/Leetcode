package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode646 {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n <= 1) {
            return n;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        // 使用dp[i]来表示以paris[i]结尾的最长长度
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
