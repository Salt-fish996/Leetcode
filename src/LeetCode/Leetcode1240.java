package LeetCode;

public class Leetcode1240 {
//    /*
//    * 使用一个二维数组dp[n+1][m+1]来表示需要的瓷砖数目
//    * dp[x][y]表示长x，宽y的房间需要的最少瓷砖数目*/
//    public int tilingRectangle(int n, int m) {
//
//        int[][] dp = new int[n + 1][m + 1];
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < m + 1; j++) {
//                //如果长或者宽是0，那么dp[i][j] = 0
//                if (i == 0 || j == 0){
//                    dp[i][j] = 0;
//                }else if (i == 1){
//                    dp[i][j] = j;
//                }else if (j == 1){
//                    dp[i][j] = i;
//                }else {
//                    //如果长宽相等
//                    if (i== j) {
//                        dp[i][j] = 1;
//                    }else {
//                        //取出长或则宽最小的
//                        int min = Math.min(i,j);
//                        //如果是长最小
//                        if(i == min){
//                            dp[i][j] = dp[i][j - i] + 1;
//                        }else {
//                            dp[i][j] = dp[i - j][j] + 1;
//                        }
//                    }
//
//                }
//            }
//        }
//        return dp[n][m];
//    }

    /**参考答案：
     * 我们定义dp[i][j]表示组成i*j大小的矩形所用最小正方形的个数。
     我们考虑如何将问题化为规模更小的问题，其实就是以下三种情况：
     1.竖直切割，将矩形分成左右两块。
     2.水平切割，将矩形分成上下两块。
     3.中间挖走了一块，导致需要将剩下的矩形分成4块，共5块。
     */
    public int tilingRectangle(int n, int m) {
        int[][] dp=new int[15][15];

        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++) {
                dp[i][j]=i==j?1:i*j;
                for(int p=1;p<i;p++)
                    dp[i][j]=Math.min(dp[i][j], dp[p][j]+dp[i-p][j]);
                for(int p=1;p<j;p++)
                    dp[i][j]=Math.min(dp[i][j], dp[i][p]+dp[i][j-p]);
                for(int x=2;x<i;x++)
                    for(int y=2;y<j;y++)
                        dp[i][j]=Math.min(dp[i][j], dp[x-1][y]+dp[x][j-y]+dp[i-x+1][y-1]+dp[i-x][j-y+1]+1);
            }
        return dp[n][m];
    }

}
