package src.LeetCode;

public class Leetcode376 {
    public int wiggleMaxLength1(int[] nums) {
        // 使用dp[i][0]表示以i为当前最后一个数,与前一个数为正数的最长长度，dp[i][1]表示以i为当前最后一个数，与前一个数的差值为负数的最长长度
        int n = nums.length;
        int[][] dp = new int[n][2];
        if (n == 0) {
            return 0;
        }
        dp[0][1] = 1;
        dp[0][0] = 1;
        int maxL = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i][1] = Math.max(dp[i][1],dp[j][0]+1);
                    maxL = Math.max(dp[i][1],maxL);
                } else if (nums[j] < nums[i]){
                    dp[i][0] = Math.max(dp[i][0],dp[j][1]+1);
                    maxL = Math.max(dp[i][0],maxL);
                }
            }
        }
        return maxL;
    }
}
