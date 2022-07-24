package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/17 19:16
 */
//使用最小花费爬楼梯,通过
public class Leetcode746 {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        //使用dp[i]来表示到达第i个楼梯所需要的花费
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        //动态转移方程dp[i]=min{dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]}
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}
