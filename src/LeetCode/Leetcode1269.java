package src.LeetCode;

/**
 * @author hyy
 * @date 2019/12/1 19:32
 */
public class Leetcode1269 {
    private static int MOD = 1_000_000_007;
    public int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps+1][steps+1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            // 注意: steps = i 时，我们最远能走到的是 i 和 arrLen-1 的较小者
            for (int j = 0; j <= Math.min(i, arrLen-1); j++) {
                dp[i][j] = dp[i-1][j];
                if (j-1>=0) { dp[i][j] += dp[i-1][j-1]; dp[i][j] %= MOD; }
                if (j < i)  { dp[i][j] += dp[i-1][j+1]; dp[i][j] %= MOD; }
            }
        }
        return dp[steps][0];
    }


    public static void main(String[] args) {
        Leetcode1269 leetcode1269 = new Leetcode1269();
        System.out.println(leetcode1269.numWays(500,2));
    }
}
