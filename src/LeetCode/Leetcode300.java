package src.LeetCode;

//最长上升子序列
public class Leetcode300 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp[i]);
            System.out.print(dp[i]+" ");
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode300 leetcode300 = new Leetcode300();
        int[] a = new int[]{1,3,6,7,9,4,10,5,6};
        leetcode300.lengthOfLIS(a);
    }
}
