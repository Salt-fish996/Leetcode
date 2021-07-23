package LeetCode;

public class Leetcode62 {

    /**使用p[i][j]来表示从左上角到(i,j)这个位置的走法，p[0][j]=1,p[i][0]=1
     * p[i][j] = p[i-1][j] + p[i][j-1]*/
    public int uniquePaths(int m, int n) {

        int[][] p = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i ==  0 || j == 0){
                    p[i][j] = 1;
                }else {
                    p[i][j] = p[i-1][j] + p[i][j-1];
                }
            }
        }
        return p[m-1][n-1];
    }

    public static void main(String[] args) {
        Leetcode62 leetcode62 = new Leetcode62();
        System.out.println(leetcode62.uniquePaths(7,3));
    }
}
