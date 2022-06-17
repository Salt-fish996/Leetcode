package src.LeetCode;

import java.util.HashMap;

public class Leetcode1653 {
    public int minimumDeletions1(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        // 使用dp[i][j]表示以j（0->a,1->b)结尾的时候最小操作数
        int[][] dp = new int[s.length()][2];
        dp[0][0] = s.charAt(0)=='a'?0:1;
        dp[0][1] = s.charAt(1) == 'b'?0:1;
        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == 'a') {
//                dp[i][0] = dp[i-1][0];
//                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0])+1;
//            } else {
//                dp[i][0] =dp[i-1][0]+1;
//                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]);
//            }
//
            dp[i][0] = dp[i-1][0]+(s.charAt(i) == 'a'?0:1);
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + (s.charAt(i)=='a'?1:0);

        }
        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }

    public int minimumDeletions(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        // 使用dp[i][j]表示以j（0->a,1->b)结尾的时候最小操作数
        int[] dp = new int[2];
        dp[0] = s.charAt(0)=='a'?0:1;
        dp[1] = s.charAt(1) == 'b'?0:1;
        for (int i = 1; i < s.length(); i++) {
            dp[1] = Math.min(dp[0],dp[1]) + (s.charAt(i)=='a'?1:0);
            dp[0] = dp[0]+(s.charAt(i) == 'a'?0:1);

        }
        return Math.min(dp[0],dp[1]);
    }
}
