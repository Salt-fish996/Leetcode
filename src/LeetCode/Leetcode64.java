package src.LeetCode;

public class Leetcode64 {
    /*最小路径和
    * 初始数组grid[m][n]
    * 动态规划最小值记录数组dp[i][j]表示到(i,j)的最小值的点
    * dp[i][j] = min{dp[i-1][j],dp[i][j-1]}+grid[i][j]
    * dp[0][0] = grid[0][0],当i=0,dp[0][j]=dp[0][j-1]+grid[0][j]
    * dp[i][0] = dp[i-1][0] + grid[i][0]**/

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j== 0){
                    if ( i == 0){
                        if (j-1>=0){
                            dp[i][j]=dp[i][j-1]+grid[i][j];
                        }
                    }else {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    }
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        Leetcode64 leetcode64 = new Leetcode64();
        int[][] g = new int[3][3];
        g[0][0] = 1;
        g[0][1] = 3;
        g[0][2] = 1;
        g[1][0] = 1;
        g[2][0] = 4;
        g[1][1] = 5;
        g[2][1] = 2;
        g[1][2] = 1;
        g[2][2] = 1;
        System.out.println(leetcode64.minPathSum(g));




    }
}
