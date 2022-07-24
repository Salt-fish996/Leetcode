package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode983 {
    /*使用dp来表示最少花费，如果这一天没有旅游，那么dp[i]=dp[i-1]
    * 否则dp[i]=min{dp[i-1]+coins[0],dp[i-7]+coins[1],dp[i-30]+coins[2]}
    * 要注意的是，如果i<7那么也可以在第一天就买一张7天的票
    * 同样，当i<30时候，那么也可以从第一天买一张30天的票*/
    public int mincostTickets(int[] days, int[] costs) {

        List<Integer> list = new ArrayList<>();
        int n = 366;
        for (int i = 0; i < days.length; i++) {
            list.add(days[i]);
            n = Math.max(n,days[i]+1);//找到最后旅行的一天
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1];
            if (list.contains(i))//如果这一天要旅游
            {
                if (i - 7>=0){
                    if (i - 30 >= 0){
                        dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[i-7]+costs[1],dp[i-30]+costs[2]));
                    }else {//如果还没有30天，那么第一天就可以买票
                        dp[i] = Math.min(Math.min(dp[i-1]+costs[0],dp[i-7]+costs[1]),costs[2]);
                    }
                }else {//如果还没有七天,那么可以第一天就买一张票
                    dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[0]+costs[1],dp[0]+costs[2]));
                }
            }
        }
        return dp[365];
    }


    public static void main(String[] args) {
        Leetcode983 leetcode983 = new Leetcode983();
        int[] a = new int[]{1,4,6,7,8,20};
        int[] b = new int[]{7,2,15};
        System.out.println(leetcode983.mincostTickets(a,b));
    }
}
