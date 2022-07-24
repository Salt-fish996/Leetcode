package src.LeetCode;

import java.util.Arrays;

/**
 * @author hyy
 * @date 2019/12/2 9:51
 */
//目标和
public class Leetcode494 {
    //使用dp[i][sum+target]来表示前i位组成目标和为target的组合数,sum为数组中的所有数字的总和
    //dp[i][sum+target]=dp[i-1][sum+target-nums[i-1]]+dp[i-1][sum+target+nums[i-1]]
    public int findTargetSumWays(int[] nums, int S) {

        int sum = 0;
        int n = nums.length;

        //计算总和
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (S > sum){
            return 0;
        }

        //初始化dp数组
        int[][] dp = new int[n][sum * 2 + 1];

        dp[0][sum - nums[0]] = 1;
        dp[0][sum + nums[0]] = 1;


        //这里要特别注意，如果第一个数是0，那么他应该有+0和-0，因此应该是两种组合
        if (nums[0] == 0){
            dp[0][sum] = 2;
        }

        int tempSum = nums[0];
        for (int i = 0; i < n; i++) {
            tempSum += nums[i];
            for (int target = -1*tempSum; target <= tempSum; target++) {
                int deIndex = sum+target+nums[i];
                int inIndex = sum+target-nums[i];
                dp[i][sum+target] = ((inIndex)>=0?dp[i-1][inIndex]:0)+((deIndex)>(2*sum)?0:dp[i-1][deIndex]);
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n - 1][sum + S];
    }

    public static void main(String[] args) {
        Leetcode494 leetcode494 = new Leetcode494();
        int[] a = new int[]{0,0,0,0,0,0,0,0,1};
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count += a[i];
        }

        System.out.println(leetcode494.findTargetSumWays(a,1));
        System.out.println(count);
    }
}
