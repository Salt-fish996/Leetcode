package LeetCode;

/**
 * @author hyy
 * @date 2019/12/2 15:00
 */
//通过
public class Leetcode96 {
    public int numTrees(int n) {

        //使用dp[i][j]来表示从i到j有多少种树
        //dp[i][j]=dp[i][k-1] + dp[k+1][j](i<=k<=j)
        int[][] dp = new int[n][n];

        //以步长来算
        for (int step = 0; step < n; step++) {
            for (int i = 0; i < n; i++) {
                int j = i + step;
                if (step == 0){
                    dp[i][j] = 1;
                }else if (j < n){
                    for (int k = i; k <= j; k++) {
                        if (k == i){
                            dp[i][j] += dp[i + 1][j];
                        }else if (k == j ){
                            dp[i][j] += dp[i][j - 1];
                        }else {
                            dp[i][j] += dp[i][k - 1] * dp[k + 1][j];
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Leetcode96 leetcode96 = new Leetcode96();
        System.out.println(leetcode96.numTrees(19));
    }
}
