package src.LeetCode;

import java.util.Map;

public class Leetcode1594 {
    // 深度遍历超时
    long max = -1;
    public int maxProductPath1(int[][] grid) {
        this.max = -1;
        this.dps(grid,0,0,1);
        return (int)(this.max%(1e9+ 7));
    }

    public void dps(int[][] grid,int row,int col,long sum) {
        long nextSum = (long) ((sum*grid[row][col]));
        if (row == grid.length-1 && col == grid[0].length-1) {
            if (nextSum >= 0) {
                max = Math.max(nextSum,max);
            }
            return;
        }
        if (nextSum == 0) {
            max = Math.max(nextSum,max);
            return;
        }
        if (row+1 < grid.length) {
            dps(grid,row+1,col, nextSum);
        }
        if (col+1 < grid[0].length) {
            dps(grid,row,col+1,nextSum);
        }
    }

    // 动态规划
    public int maxProductPath(int[][] grid) {
        long[][][] dp = new long[grid.length][grid[0].length][2];
        // 使用dp[i][j][0]表示(x,y)的最大值，dp[i][j][1]表示最大值
        // 那么当grid[x][y]<0时候，dp[x][y][0]=max(dp[x-1][y][1],dp[x][y-1][1],dp[x][y][1]=min(dp[x-1][y][0],dp[x][y-1][0)
        // grid[x][y]>0时候同理

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if (i == 0) {
                   if (j == 0) {
                       dp[0][0][0] = grid[0][0];
                       dp[0][0][1] = grid[0][0];
                   }else {
                       if (grid[i][j] < 0) {
                           dp[i][j][0] = dp[i][j-1][1] * grid[i][j];
                           dp[i][j][1] = dp[i][j-1][0] * grid[i][j];
                       } else {
                           dp[i][j][0] = dp[i][j-1][0] * grid[i][j];
                           dp[i][j][1] = dp[i][j-1][1] * grid[i][j];
                       }
                   }
               } else {
                   if (j == 0) {
                       if (grid[i][j] < 0) {
                           dp[i][j][0] = dp[i-1][j][1] * grid[i][j];
                           dp[i][j][1] = dp[i-1][j][0] * grid[i][j];
                       } else {
                           dp[i][j][0] = dp[i-1][j][0] * grid[i][j];
                           dp[i][j][1] = dp[i-1][j][1] * grid[i][j];
                       }
                   } else {
                       if (grid[i][j] < 0) {
                           dp[i][j][0] = grid[i][j] *Math.max(dp[i-1][j][1],dp[i][j-1][1]);
                           dp[i][j][1] = grid[i][j] * Math.min(dp[i-1][j][0],dp[i][j-1][0]);
                       } else {
                           dp[i][j][0] = grid[i][j] *Math.min(dp[i-1][j][0],dp[i][j-1][0]);
                           dp[i][j][1] = grid[i][j] * Math.max(dp[i-1][j][1],dp[i][j-1][1]);
                       }
                   }
               }
            }
        }
        if (dp[grid.length-1][grid[0].length-1][1] < 0) {
            return -1;
        }
        return (int) (dp[grid.length-1][grid[0].length-1][1]%(1e9+7));
    }
    public static void main(String[] args) {
        String s = "[[2,1,3,0,-3,3,-4,4,0,-4],[-4,-3,2,2,3,-3,1,-1,1,-2],[-2,0,-4,2,4,-3,-4,-1,3,4],[-1,0,1,0,-3,3,-2,-3,1,0],[0,-1,-2,0,-3,-4,0,3,-2,-2],[-4,-2,0,-1,0,-3,0,4,0,-3],[-3,-4,2,1,0,-4,2,-4,-1,-3],[3,-2,0,-4,1,0,1,-3,-1,-1],[3,-4,0,2,0,-2,2,-4,-2,4],[0,4,0,-3,-4,3,3,-1,-2,-2]]";
        String[] ss = s.split("],");
        int row = ss.length;
        int col = ss[0].split(",").length;
        int[][] grid = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] sss = ss[i].replace("[","").replace("]","").split(",");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(sss[j]);
            }
        }

        Leetcode1594 l = new Leetcode1594();
        System.out.println(l.maxProductPath(grid));
    }
}
