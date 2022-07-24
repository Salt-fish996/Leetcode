package src.LeetCode;

import java.util.Arrays;

//最大正方形，通过2019年11月14
public class Leetcode221 {
    //使用dp[i][j]来表示以(i,j)这个格子为正方形最右下角的点
    //如果matrix[i][j]=0，那么dp[i][j]=0
    //如果matrix[i][j]=1，那么dp[i][j]=min{min{dp[i][j-1]+1,dp[i-1][j]},min{dp[i-1][j] + 1,dp[i][j-1]}}
    //还要考虑dp[i-1][j-1],如果dp[i-dp[i][j]][j-dp[i][j]]=0,那么dp[i][j]不变，否则dp[i][j]++
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int max = 0;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else {
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                        max = Math.max(max,dp[i][j]);
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]),Math.min(dp[i][j-1],dp[i-1][j] + 1));
                        if (dp[i][j] == 0){
                            dp[i][j] = 1;
                        }else {
                            if (dp[i-dp[i][j]][j-dp[i][j]] == 0) dp[i][j]--;
                            dp[i][j] ++;
                        }

                        max = Math.max(max,dp[i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return max*max;
    }

    public static void main(String[] args) {
        Leetcode221 leetcode221 = new Leetcode221();
       String[][] a = new String[10][9];
        a[0] = new String[]{"1","0","1","0","0","1","1","1","0"};
        a[1] = new String[]{"1","1","1","0","0","0","0","0","1"};
        a[2] = new String[]{"0","0","1","1","0","0","0","1","1"};
        a[3] = new String[]{"0","1","1","0","0","1","0","0","1"};
        a[4] = new String[]{"1","1","1","0","1","0","0","1","0"};
        a[5] = new String[]{"0","1","1","1","1","1","1","0","1"};
        a[6] = new String[]{"1","0","1","1","1","0","0","1","0"};
        a[7] = new String[]{"1","1","1","0","1","0","0","0","1"};
        a[8] = new String[]{"0","1","1","1","1","0","0","1","0"};
        a[9] = new String[]{"1","0","0","1","1","1","0","0","0"};

        char[][] b = new char[10][9];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                b[i][j] = a[i][j].charAt(0);
            }
        }
        System.out.println(leetcode221.maximalSquare(b));
    }
}
