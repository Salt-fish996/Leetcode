package LeetCode;

//通过的程序，注意在计算k=y1-y2的时候一定要使用long而不能够使用int，测试数据会产生int溢出，如65536*65536 = 0
public class Leetcode149 {
/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
*/
    //对数组排序
    public void sortPoints(int[][] points){
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i][0] >points[j][0]){
                    int temp = points[i][0];
                    points[i][0] = points[j][0];
                    points[j][0] = temp;
                    temp = points[i][1];
                    points[i][1] = points[j][1];
                    points[j][1] = temp;
                }
            }
        }
    }
    //求在一条直线上的点
    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        int size = points.length;//一共size个点
        sortPoints(points);
        int max = 1;
        for (int i = 0; i < size; i++) {
            int sum = 1;
            //如果后面的点的坐标与当前坐标相同，那么不必计算，直接将点数加1即可
            while (i+1<size && points[i+1][0] == points[i][0] && points[i][1] == points[i+1][1]){
                i++;
                sum++;
            }
            max = Math.max(sum,max);
            for (int j = i+1; j < size; j++) {
                if (points[i][0] == points[j][0]){//如果已知的两个点在平行于y轴的线上，那么只用计算x坐标相等的点即可
                    int count = sum +1;
                    for (int k = j+1; k < points.length; k++) {
                        if (points[k][0] == points[j][0])count++;
                    }
                    max = Math.max(count,max);
                }else {
                    //这个方法由于除法产生误差，因此不能够使用
//                    double k = (points[j][1] - points[i][1])/(points[j][0] - points[i][0]);
//                    double b = points[j][1] - k*points[j][0];
//                    int count = sum + 1;
//                    for (int l = j+1; l < size; l++) {
//                        if (points[l][1] - k*points[l][0] == b) count++;
//                    }
//                    max = Math.max(count,max);

                    //由于斜率会产生计算误差，如10/3=3.33333...因此将y=kx+b=(y1-y2)/(x1-x2)x+b转化为(x1-x2)y=(y1-y2)x+b
                    //计算出k = y1-y2
                    long k = points[j][1] - points[i][1];
                    //计算出b
                    long b = points[i][1]*(points[j][0] - points[i][0]) - points[i][0]*k;
                    int count = sum + 1;
                    for (int l = j+1; l < size; l++) {
                       // if (k !=0 && points[l][0] != 0 && k*points[l][0] == 0) continue;
                        if (points[l][1]*(points[j][0] - points[i][0]) - points[l][0]*k == b) count++;
                    }
                    max = Math.max(count,max);
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode149 leetcode149 = new Leetcode149();
        int[][] points = new int[4][2];
        points[0][0] = 3;
        points[0][1] = 1;
        points[1][0] = 12;
        points[1][1] = 3;
        points[2][0] = 3;
        points[2][1] = 1;
        points[3][0] = -6;
        points[3][1] = -1;
//        int[][] points = new int[6][2];
//        points[0][0] = 1;
//        points[0][1] = 1;
//        points[1][0] = 3;
//        points[1][1] = 2;
//        points[2][0] = 5;
//        points[2][1] = 3;
//        points[3][0] = 4;
//        points[3][1] = 1;
//        points[4][0] = 2;
//        points[4][1] = 3;
//        points[5][0] = 1;
//        points[5][1] = 4;
//        int[][] points = new int[3][2];
//        points[0][0] = 0;
//        points[0][1] = 0;
//        points[1][0] = 1;
//        points[1][1] = 65536;
//        points[2][0] = 65536;
//        points[2][1] = 0;
        System.out.println(leetcode149.maxPoints(points));

    }
}
