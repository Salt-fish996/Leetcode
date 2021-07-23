package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hyy
 * @date 2019/12/4 12:58
 */
public class Leetcode542 {

    static int count = 0;
    //动态规划
    //使用dp[i][j]来表示(i,j)到0的最短距离
    //那么dp[i][j]=0(matrix[i][j]=0),min(dp[i-1][j],dp[i+1][j],dp[i][j+1],dp[i][j-1]}+1
    //First pass: check for left and top
    public int[][] updateMatrix(int[][] matrix) {

        count++;

        int rows = matrix.length;
        if (rows == 0){
            return new int[rows][0];
        }
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        if (count == 47){

            return dist;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        //Second pass: check for bottom and right
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < cols - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
        return dist;
    }

}
