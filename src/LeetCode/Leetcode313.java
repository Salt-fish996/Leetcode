package LeetCode;

public class Leetcode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] dp = new int[n+1];
        int[] sit = new int[primes.length];//位置
        dp[0] = 1;

        for (int i = 1; i < n+1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < sit.length; j++) {
                min =Math.min(dp[sit[j]] *primes[j],min) ;
            }

            dp[i] = min;
            for (int j = 0; j < sit.length; j++) {
                if (min >= dp[sit[j]] *primes[j]) sit[j] += 1;
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] p = new int[]{2,7,13,19};
        Leetcode313 leetcode313 = new Leetcode313();
        System.out.println(leetcode313.nthSuperUglyNumber(12,p));
    }
}
