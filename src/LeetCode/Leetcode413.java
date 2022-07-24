package src.LeetCode;

/**
 * @author hyy
 * @date 2020/4/22 9:18
 */
//通过，100%
public class Leetcode413 {
    public int numberOfArithmeticSlices(int[] A) {

        //使用数组dp[i]表示以i位为最后一位的等差数列个数，使用count记录以A[i]结尾的
        //等差数列的差，那么如果A[i+1]-A[i]=count,那么dp[i+1]=dp[i]+1,否则
        //dp[i+1]=0,count = A[i+1]-A[i]]
        int n = A.length;
        //如果数组中的个数小于3，那么直接返回0不存在等差数列
        if (n < 3) {
            return  0;
        }
        //检查等差数列是不是存在
        int[] dp = new int[n];
        int count = A[1] - A[0];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == count) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            } else {
                count = A[i] - A[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Leetcode413 leetcode413 = new Leetcode413();
        System.out.println(leetcode413.numberOfArithmeticSlices(new int[]{2,4,6,8,10}));
    }
}
