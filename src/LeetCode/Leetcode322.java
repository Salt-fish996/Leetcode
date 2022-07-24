package src.LeetCode;

public class Leetcode322 {
    /*找硬币，要求找出最少的硬币数目组成amount
    * 使用dp[i]来代表组成i所需要的硬币数目
    * dp[i] = min{dp[i-coins[0]],dp[i-coins[1]],dp[i-coins[2]...}+1*/
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >=0 && dp[i - coins[j]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]]+1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];

    }


    public static void main(String[] args) {
        Leetcode322 leetcode322 = new Leetcode322();
        int[] coins = new int[]{7,2,5};
        System.out.println(leetcode322.coinChange(coins,3));
    }
}
