package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/17 12:38
 */
//预测赢家，通过
public class Leetcode484 {
    static int count = 0;
    //返回先手拿的最大分数
    public int maxSumScore(int begin, int end, int[] nums, int[][] dp, int sum){

        //如果已经没有数了，那么能取得的最大值就是0
        if (begin > end){
            return 0;
        }
        //如果只剩下一个数，那么只能够取这个数
        if (begin == end){
            return nums[begin];
        }
        //如果已经计算过这个范围内先手的最大值,那么直接返回
        if (dp[begin][end] != 0){
            return dp[begin][end];
        }

        //如果没有计算过，那么进行计算,max表示另一个人拿的分数，所以让别人拿的更少，那么自己就是最多的
        int max = Integer.MAX_VALUE;
        //取begin位置上的数
        int beginSum = maxSumScore(begin + 1, end, nums, dp,sum - nums[begin]);

        //取end位置上的数
        int endSum = maxSumScore(begin,end - 1, nums, dp, sum - nums[end]);

        //比较那个得分多，要求自己得分最多，也就是让对方得分最少
        max = Math.max(sum - beginSum, sum - endSum);

        dp[begin][end] = max;
        return max;
    }
    public boolean PredictTheWinner(int[] nums) {

        int sum = 0;
        int n = nums.length;
        //如果只有一位数
        if (n == 1){
            return true;
        }
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int[][] dp = new int[n][n];
        int first = maxSumScore(0,n-1,nums,dp,sum);
        return first >= (sum - first);
    }


    public static void main(String[] args) {
        Leetcode484 leetcode484 = new Leetcode484();
        int[] a = new int[]{1,5,233,7,8,6,46,46,56,1,661,9,464,6,8,89,8959,59,2,2};
        System.out.println(leetcode484.PredictTheWinner(a));
    }
}
