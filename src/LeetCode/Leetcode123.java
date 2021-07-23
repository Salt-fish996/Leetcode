package LeetCode;

/**
 * @author hyy
 * @date 2019/11/20 11:10
 */
// 买卖股票的最佳时机 III,通过
public class Leetcode123 {
    //内存溢出
    public int maxProfit1(int[] prices) {
        //使用dp[i][j]表示在第i天到第j天期间买卖股票能够获得的最大利益
        int n = prices.length;

        for (;n >= 0;) {
            if (prices[n - 1] == 0){
                n--;
            }else break;
        }
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int min = prices[i];
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(Math.max(0,prices[j] - min),dp[i][j-1]);
                min = Math.min(min,prices[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[0][i] + dp[i][n - 1],max);
        }

        return max;
    }


    //通过
    public int maxProfit(int[] prices) {

        //优化，只使用leftDp[i]表示从0到位置i卖出一次股票所能够获得的最大利润
        //使用rightDp[i]表示从i到n-1能够获得的最大利益
        int n = prices.length;
        //除去数组后面的0，因为如果是0没必要进行计算
        for (; n >= 1 ;) {
            if (prices[n - 1] == 0){
                n --;
            }else break;
        }
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        if (n == 0){
            return 0;
        }

        //计算leftDp和rightDp,左边要取最小值，然后用prices[i]-leftMin
        //右边要取最大值用rightMax-prices[i]
        int leftMin = prices[0];
        int rightMx = prices[n - 1];

        for (int i = 0; i <= n; i++) {
            if (i != n){
                leftDp[i] = Math.max((i - 1 >0) ?leftDp[i - 1]:0,prices[i] - leftMin);
                leftMin = Math.min(leftMin,prices[i]);
            }

            if (i != 0){
                rightDp[n - i] = Math.max(rightMx - prices[n - i],(n-i+1)<n?rightDp[n - i +1]:0);
                rightMx = Math.max(rightMx,prices[n - i]);
            }

        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue,leftDp[i] + rightDp[i]);
        }

        return maxValue;
    }
    public static void main(String[] args) {
        Leetcode123 leetcode123 = new Leetcode123();
        int[] a = new int[]{};
        System.out.println(leetcode123.maxProfit(a));
    }
}
