package src.LeetCode;

public class Leetcode264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        dp[0] = 1;

        for (int i = 1; i < n+1; i++) {

            dp[i] = Math.min(dp[x1]*2,Math.min(dp[x2]*3,dp[x3]*5));
            if (dp[i] >= dp[x1]*2) x1++;
            if (dp[i] >= dp[x2]*3) x2++;
            if (dp[i] >= dp[x3]*5) x3++;
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        Leetcode264 leetcode264 = new Leetcode264();
        System.out.println(leetcode264.nthUglyNumber(20));
    }
}
