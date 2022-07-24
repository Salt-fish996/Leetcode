package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/20 10:51
 */
public class Leetcode121 {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int max = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(prices[j] - prices[i],max);
            }
        }

        return max;
    }
}
