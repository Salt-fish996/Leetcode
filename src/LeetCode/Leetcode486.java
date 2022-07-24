package src.LeetCode;

public class Leetcode486 {

    //自己没有做出来，这是网上的答案
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        //DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }


    public static void main(String[] args) {
        Leetcode486 leetcode486 = new Leetcode486();
        int[] nums = new int[]{1,5,2};
        System.out.println(leetcode486.PredictTheWinner(nums));
    }
}
