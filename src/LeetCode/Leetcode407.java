package LeetCode;

/*错误答案，思路错误*/
public class Leetcode407 {
    /**
     * 给定一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     *
     *  
     *
     * 说明:
     *
     * m 和 n 都是小于110的整数。每一个单位的高度都大于 0 且小于 20000。
     *
     *  
     *
     * 示例：
     *
     * 给出如下 3x6 的高度图:
     * [
     *   [1,4,3,1,3,2],
     *   [3,2,1,3,2,4],
     *   [2,3,3,2,3,1]
     * ]
     *
     * 返回 4。
     **/
    public int trapRainWater(int[][] heightMap) {

        //用4个二维数组hleftMax[i][j],hrightMax[i][j]来表示横向左右的最大值
        //用stopMax[i][j],sBottomMax[i][j]来表示竖向上下最大值
        //那么(I,j)能够存储的雨水量就是min(hleftMax[i][j],hrightMax[i][j],stopMax[i][j],sBottomMax[i][j])
        int n = heightMap.length;
        int m = heightMap[0].length;
        int[][] hLeftMax = new int[n][m];
        int[][] hRightMax = new int[n][m];
        int[][] stopMax = new int[n][m];
        int[][] sBottomMax = new int[n][m];

        //计算横向最大值
        for (int i = 0; i < n; i++) {
            //计算左最大值
            hLeftMax[i][0] = heightMap[i][0];
            for (int j = 1; j < m-1; j++) {
                hLeftMax[i][j] = Math.max(hLeftMax[i][j-1],heightMap[i][j]);
            }

            //计算右最大值
            hRightMax[i][m-1] = heightMap[i][m-1];
            for (int j = m-2; j >= 0; j--) {
                hRightMax[i][j] = Math.max(hRightMax[i][j+1],heightMap[i][j]);
            }
        }

        //计算竖向最大值
        for (int i = 0; i < m; i++) {
            //计算向下最大值
            sBottomMax[0][i] = heightMap[0][i];
            for (int j = 1; j < n; j++) {
                sBottomMax[j][i] = Math.max(sBottomMax[j-1][i],heightMap[j][i]);
            }

            //计算向上最大值
            stopMax[n-1][i] = heightMap[n-1][i];
            for (int j = n-2; j >= 0; j--) {
                stopMax[j][i] = Math.max(stopMax[j+1][i],heightMap[j][i]);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += Math.min(Math.min(hLeftMax[i][j],hRightMax[i][j]),Math.min(sBottomMax[i][j],stopMax[i][j])) - heightMap[i][j];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Leetcode407 leetcode407 = new Leetcode407();
        int[][] heights = new int[3][6];
        heights[0] = new int[]{1,4,3,1,3,2};
        heights[0] = new int[]{3,2,1,3,2,4};
        heights[0] = new int[]{2,3,3,2,3,1};
        System.out.println(leetcode407.trapRainWater(heights));
    }
}
