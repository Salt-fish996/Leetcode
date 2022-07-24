package src.LeetCode;

import java.util.Arrays;

/**
 * @author hyy
 * @date 2019/11/17 11:07
 */
//我能赢吗,通过，注意这道题的和是累计和
public class Leetcode464 {
    public boolean check(int stat, int target,int max,int[] dp){
        //state用于记录选择的数字
        if (dp[stat] != 0){
            //如果计算过了
            return dp[stat] == 1;
        }

        //如果在当前状态无论取何值都不能够获得胜利，那么result不会被修改，直接返回true
        boolean result = false;

        //选择数字
        for (int i = max; i > 0; i--) {
            //设置第i位是1
            int temp = 1<<i;
            if ((stat & temp)!=0){
                //表示i已经选过了
                continue;
            }

            //如果取i达到了满足累计和>=target，那么直接返回true,否则检查取得这个数以后
            //对方不能使目标和到达target,那么也返回true
            if (i >= target || !check((stat | temp),target - i,max,dp)){
                result = true;
                break;
            }
        }

        dp[stat] = result?1:2;
        return result;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        //特别注意，desiredTotal是累计和，不是一个人取值的和
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 <desiredTotal){
            return false;
        }
        if (maxChoosableInteger >= desiredTotal){
            return true;
        }
        //使用dp[i]来表示在某个状态序列的情况下，先手能不能赢
        int[] dp = new int[1<<maxChoosableInteger+1];
        boolean check = check(0, desiredTotal, maxChoosableInteger, dp);
        System.out.println(Arrays.toString(dp));
        return check;

    }

    public static void main(String[] args) {
        Leetcode464 leetcode464 = new Leetcode464();
        System.out.println(leetcode464.canIWin(10,11));
    }
}
