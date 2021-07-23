package DynamicAlgor;

public class MinestPathLong {
    /*二维平面，从右下角到右上角一共有多少种方式
    * 首先定义一个二维数组p[m][n],那么p[m][n]=p[m-1][n]+p[m][n-1]
    * 初始化状态，p[0][i]=1,p[i][0]=1*/
    public int dp(int m,int n){//m表示行，n表示列
        int[][] p = new int[m][n];
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0){
                    p[i][j] = 1;
                }else {
                    p[i][j] = p[i-1][j] + p[i][j-1];
                }
            }
        }
        return p[m-1][n-1];
    }


    public static void main(String[] args) {
        MinestPathLong minestPathLong = new MinestPathLong();
        System.out.println(minestPathLong.dp(5,5));
    }

}
