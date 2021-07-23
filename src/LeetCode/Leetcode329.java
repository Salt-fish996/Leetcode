package LeetCode;

/**
 * @author hyy
 * @date 2019/12/4 12:29
 */
//矩阵中的最长递增路径，通过，90.03
public class Leetcode329 {
    public static int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    //返回从(i,j)开始的最长递增序列的长度
    private int dfs(int[][] matrix, int[][] maxLongWay, int x, int y,int m, int n){
        if (maxLongWay[x][y] != 0){
            return maxLongWay[x][y];
        }

        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nowX = x + dir[i][0];
            int nowY = y + dir[i][1];
            if (nowX >= 0 && nowX < m && nowY >= 0 && nowY < n){
                if (matrix[nowX][nowY] > matrix[x][y]){
                    max = Math.max(max,dfs(matrix,maxLongWay,nowX,nowY,m,n));
                }
            }
        }
        maxLongWay[x][y] = max + 1;
        return max + 1;
    }
    public int longestIncreasingPath(int[][] matrix) {

        //矩阵中的最长递增序列
        //对于matrix数组中的每一个点开始使用dfs进行遍历，dfs函数返回从某一点开始的最长的递增序列的长度
        //并且记录到数组maxLongWay中，maxLongWay[i][j]表示从(i,j)位置开始的最长的递增序列的长度
        int m = matrix.length;
        if (m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] maxLongWay = new int[m][n];

        int maxCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maxLongWay[i][j] != 0){
                    maxCount = Math.max(maxLongWay[i][j],maxCount);
                }else {
                    maxCount = Math.max(maxCount,dfs(matrix,maxLongWay,i,j,m,n));
                }
            }
        }
        return maxCount;
    }
}
