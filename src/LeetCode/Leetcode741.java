package src.LeetCode;

public class Leetcode741 {
//    //使用maxValue[l][i][j]表示在到达地i行的时候，第一条路过第i点，第二条路路过第j点
//    //maxValue[l][i][j]=max{maxValue[l][i-1][j-1],maxValue[l-1][i][j]}+grid[l][i]+grid[l][j]
//    public int cherryPickup(int[][] grid) {
//
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][][] maxValue = new int[m][n][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = j; k < n; k++) {
//                    if (i == 0){//如果在第一层
//                        if (k == 0){//第一个点[0][0][0]
//                            maxValue[i][j][k] = grid[i][j] == 1?1:(grid[i][j] == 0?0:Integer.MIN_VALUE);
//                        }else {
//                            if (j == 0){
//                                maxValue[i][j][k] = grid[i][j] == -1?Integer.MIN_VALUE:grid[i][j];
//                                if (maxValue[i][j][k] != Integer.MIN_VALUE) {
//                                    maxValue[i][j][k] += grid[i][k-1] == -1?Integer.MIN_VALUE:grid[i][j];
//                                }
//                            }else if (k == j){
//                                maxValue[i][j][k] = grid[i][j] == -1?Integer.MIN_VALUE:(maxValue[i][j-1][k-1] == Integer.MIN_VALUE?Integer.MIN_VALUE:(maxValue[i][j-1][k-1] + grid[i][j]));
//
//                            }else {
//                                maxValue[i][j][k] = (grid[i][j] == -1)||(grid[i][k] == -1)?Integer.MIN_VALUE:(maxValue[i][j-1][k-1] == Integer.MIN_VALUE?Integer.MIN_VALUE:(maxValue[i][j-1][k-1] + grid[i][j] + grid[i][k]));
//                            }
//                        }
//
//
//                    }else {//不在第一层
//                        if (j == 0){
//                            if (k == 0){
//                                maxValue[i][j][k] = maxValue[i - 1][j][k];
//                                maxValue[i][j][k] += maxValue[i][j][k] == Integer.MIN_VALUE?0:(grid[i][j] == -1?0:grid[i][j]);
//                            }else {
//                                maxValue[i][j][k] = Math.max(maxValue[i-1][j][k],maxValue[i][j][k-1]);
//                                maxValue[i][j][k] += maxValue[i][j][k] == Integer.MIN_VALUE?0:(grid[i][j] == -1?0:grid[i][j] + grid[i][k] == -1?0:grid[i][k]);
//                            }
//                        }else {
//                            if (j == k){
//                                maxValue[i][j][k] = Math.max(maxValue[i-1][j][k],maxValue[i][j-1][k-1]);
//                                maxValue[i][j][k] += maxValue[i][j][k] == Integer.MIN_VALUE?0:(grid[i][j] == -1?0:grid[i][j]);
//                            }else {
//                                maxValue[i][j][k] = Math.max(maxValue[i-1][j][k],maxValue[i][j][k-1]);
//                                maxValue[i][j][k] += maxValue[i][j][k] == Integer.MIN_VALUE?0:(grid[i][j] == -1?0:grid[i][j] + grid[i][k] == -1?0:grid[i][k]);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return maxValue[m-1][n-1][n-1];
//    }

    //参考答案
    public int cherryPickup(int[][] grid) {
        int len = grid.length;
        int[][][] dp = new int[2 * len - 1][len][len];
        dp[0][0][0] = grid[0][0];
        for (int step = 1; step < dp.length; step++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    dp[step][i][j] = -1;
                    // 不符合条件
                    if (step - i >= len || step - j >= len || step - i < 0 || step - j < 0) continue;
                    if (grid[i][step - i] <= -1 || grid[j][step - j] <= -1) {
                        dp[step][i][j] = -1;
                    } else {
                        // four path value
                        int bup = i - 1 >= 0 && j - 1 >= 0 ? dp[step - 1][i - 1][j - 1] : -1;
                        int blf = dp[step - 1][i][j];
                        int ul = i - 1 >= 0 ? dp[step - 1][i - 1][j] : -1;
                        int lu = j - 1 >= 0 ? dp[step - 1][i][j - 1] : -1;
                        int max = Math.max(Math.max(bup, blf), Math.max(ul, lu));
                        // four path is -1 then set this as not enable to pass
                        if (max == -1) {
                            dp[step][i][j] = -1;
                            continue;
                        } else {
                            // how many cherry to add because we could only carry one cherry one time so this
                            if (i != j) {
                                dp[step][i][j] = max + grid[i][step - i] + grid[j][step - j];
                            } else {
                                dp[step][i][j] = max + grid[i][step - i];
                            }
                        }
                    }
                }
            }
        }
        return dp[dp.length - 1][len - 1][len - 1] == -1 ? 0 : dp[dp.length - 1][len - 1][len - 1];
    }

}
