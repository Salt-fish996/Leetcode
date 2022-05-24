package src.LeetCode;

public class Leetcode1155 {
    private static final int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[31][1001];
        int min = Math.min(k,target);
        for (int i = 1; i <= min; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n*k; j++) {
                for (int l = 1; l <= k && j-l >= 0 ; l++) {
                    dp[i][j] = (dp[i][j]+dp[i-1][j-l]) % (MOD);
                }

            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        Leetcode1155 l = new Leetcode1155();
        System.out.println(l.numRollsToTarget(30,30,500));
    }
}
