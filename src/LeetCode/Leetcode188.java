package LeetCode;

import java.util.ArrayList;

/**
 * @author hyy
 * @date 2019/11/20 12:38
 */
// 买卖股票的最佳时机 IV,未通过211测试用例通过208
public class Leetcode188 {

    //参考答案，来自leetCode
    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
    int maxProfit_k_any(int max_k, int[] prices) {
        int n = prices.length;
        if (max_k > n / 2)
            return maxProfit_k_inf(prices);

        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++)
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        return dp[n - 1][max_k][0];
    }
    static int money = 0;
    /**
     * @param k 表示已经划分了多少次
     * @param index 表示上一次的划分位置
     * @param list 存储当前的划分
     * */
    public void maxValue(int[][] dp, int index, int k, ArrayList<Integer> list){
        //如果已经买卖了k次或者已经不能够再买卖了，那么直接返回
        if ( k == 1 || index >= dp.length){
            int temp = 0;
            int sum = 0;
            for (Integer l:list
                 ) {
                sum += dp[temp][l];
                temp = l;
            }
            sum += dp[temp][dp.length - 1];
            //取最大利益
            money = Math.max(sum,money);
            return;
        }


        int max = dp[index][dp.length - 1];
        int tempMax = 0;
        for (int i = index + 1; i < dp.length; i++) {
            if (dp[index][i] != 0 && dp[index][i] > tempMax){
                list.add(i);
                tempMax = dp[index][i];
                maxValue(dp, i, k - 1, list);
                list.remove(Integer.valueOf(i));
                if (dp[index][i] == max){
                    break;
                }
            }
        }
    }
    public int maxProfit(int k, int[] prices) {

        money = 0;
        //使用dp[i][j][k]表示在第i天到第j天期间买卖股票k次能够获得的最大利益
        int n = prices.length;

        if (n == 0){
            return 0;
        }
        for (;n >= 1;) {
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
        ArrayList list = new ArrayList();
        maxValue(dp,0,k,list);
        return money;
    }


    public static void main(String[] args) {
        Leetcode188 leetcode123 = new Leetcode188();
        int[] a = new int[]{3,2,6,5,0,3};
        System.out.println(leetcode123.maxProfit(2,a));
    }
}
