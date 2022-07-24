package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/20 11:03
 */
public class Leetcode122 {
    public int maxProfit(int[] prices) {

        //对于可以多次买卖股票，那么只要发现比前面的值小的数，那么就可以卖出
        int n = prices.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int now = prices[i] - min;
            //如果当前的价格大于min，那么将min变成prices
            max += Math.max(0,now);
            min = prices[i];
        }
        return max;
    }
}
