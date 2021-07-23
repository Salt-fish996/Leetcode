package CamupsRecruitTecent;

import java.util.Scanner;

public class PitFlowers {
    /*题目描述:
    * 花匠小Q养了两种花，一种红花，一种白花，
    * 现在小Q用这些话进行摆放，摆放的时候连续的白花数量只能够是K的倍数(倍数可以使0)
    * ，现在给出a和b，小Q想知道长度为[a,b]的合法摆花方案有多少种
    *
    *
    * 分析思路：
    * 使用dp[i][0]来表示长度为i的摆花方案中以红花结尾，也就是最后一个是红花的种类数
    * 以红花结尾的种类数为dp[i-1][0]+dp[i-1][1],因为无论是i-1长度的摆花方案是怎样摆放的，最后一个都可以是红花
    * 使用dp[i][1]来表示长度为i的摆花方案中以白花结尾，也就是最后一个是白花的种类数
    * 以白花为最后一个花的种类数目应该等于∑dp[i-kK][0]+dp[i-kK][1](k为自然数），因为白花只能连续摆放K的倍数，要使长度为i的最后一个花为白花，
    * 那么必须是连续kK棵白花连续
    * */

    public int countPutFlowersDifferent(int k,int a,int b){
        int[][] dp = new int[b+1][2];
        dp[0][0] = 1;
        int[] sum = new int[b+1];
        for (int i = 1; i < b+1; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            for (int j = k; j <= i; j += k) {
                dp[i][1] += dp[i - j][0] ;
            }
            sum[i] = sum[i-1] + dp[i][0] + dp[i][1];
        }
        return sum[b] - sum[a-1];
    }


    public static void main(String[] args) {
        PitFlowers pitFlowers = new PitFlowers();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(pitFlowers.countPutFlowersDifferent(k,a,b));
        }
    }
}
