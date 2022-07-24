package src.LeetCode;

public class Leetcode63 {
    /*当数组中有障碍物时，如果这个点有障碍物，那么p[i][j]=0表示这个点不能够到达，其余与62题相同*/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else if (i == 0 || j == 0){
                    if (i == 0){
                        if (j - 1 <0){
                            dp[i][j] = 1;
                        }else {
                            dp[i][j] = dp[i][j-1];
                        }
                    }else {
                        dp[i][j] = dp[i - 1][j];
                    }

                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }

        }
        return dp[m-1][n-1];
    }
}
