package src.LeetCode;

//通过
public class Leetcode279 {
    //使用dp[i]表示组成i的最少的数目
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            if ((int)Math.sqrt(i) * (int)Math.sqrt(i) == i){
                dp[i] = 1;
            }else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = (int)Math.sqrt(i); j >= 1 ; j--) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(i + ":"+dp[i]);
        }
        return dp[n];

    }


    public static void main(String[] args) {
        Leetcode279 leetcode279 = new Leetcode279();
        System.out.println(leetcode279.numSquares(2000000));
    }
}
