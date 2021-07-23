package LeetCode;

public class Leetcode45 {
    //方法1(从后往前，会超时):
    //使用数组dp[i]表示跳到第i个位置所需要的最少步数
    //因此dp[i] = Math.min(((i - j) <= nums[j])&&dp[j] != Integer.MAX_VALUE?(dp[j]+1):Integer.MAX_VALUE ,dp[i]);(0<=J<i)
    public int jump(int[] nums) {

        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                dp[i] = Math.min(((i - j) <= nums[j])&&dp[j] != Integer.MAX_VALUE?(dp[j]+1):Integer.MAX_VALUE ,dp[i]);
            }
        }
        return dp[n - 1];
    }

    //从前往后，可以通过
    public int jump2(int[] nums) {

        int n = nums.length;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] =Integer.MAX_VALUE;
        }
        dp[0] = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (j + i < n){
                    dp[j + i] = Math.min(dp[i] + 1,dp[j + i]);
                }
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Leetcode45 leetcode45 = new Leetcode45();
        int[] a = new int[]{2,3,1,1,4};
        System.out.println("从前往后:" + leetcode45.jump2(a));
        System.out.println("从后往前:" + leetcode45.jump(a));
    }
}
