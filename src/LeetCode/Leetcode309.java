package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/20 17:19
 */
//最佳买卖股票时机含冷冻期,通过
public class Leetcode309 {
    //使用dp[i][0]表示第i天手里面没有股票时候的利润，可能是吧第i-1天的股票卖了，
    // 也可能是第i-1天的时候就没有股票dp[i][0]=max{dp[i-1][1]+prices[i],dp[i-1][0]}
    //使用dp[i][1]表示第i天手里面有股票时候的利润,这个股票可能来源于第i-1天，
    // 也可能是今天刚买的，dp[i][1]=max{dp[i-1][1],dp[i-2][0]-prices[i]}
    public int maxProfit(int[] prices) {

        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];


        for (int i = 0; i < n; i++) {
            if (i == 0){
                dp[i][0] = 0;
                dp[i][1] = -1*prices[i];
            }else {
                if (i == 1){
                    dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
                    dp[i][1] = Math.max(dp[i - 1][1],-1*prices[i]);
                }else {
                    dp[i][0] = Math.max(dp[i - 1][1] + prices[i],dp[i - 1][0]);
                    dp[i][1] = Math.max(dp[i - 1][1],dp[i - 2][0] - prices[i]);
                }
            }
        }

        return dp[n - 1][0];
    }
}
