package LeetCode;

/**
 * @author hyy
 * @date 2019/11/14 19:37
 */
//最大矩形，通过
public class Leetcode85 {
    //使用width[i][j]表示横向一共有多少连续的1
    //使用longth[i][j]表示纵向一共有多少连续的1
    public int maximalRectangle(char[][] matrix) {


        int m = matrix.length;
        if (m == 0){
            return 0;
        }
        int n = matrix[0].length;

        int[][] width = new int[m][n];
        int[][] longth = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0'){
                    width[i][j] = 0;
                    longth[i][j] = 0;
                }else if (i == 0){
                    longth[i][j] = 1;
                    if (j == 0){
                        width[i][j] = 1;
                    }else {
                        width[i][j] = width[i][j - 1] + 1;
                    }
                }else {
                    longth[i][j] = longth[i-1][j] + 1;
                    if (j == 0){
                        width[i][j] = 1;
                    }else {
                        width[i][j] = width[i][j - 1] + 1;
                    }
                }
                System.out.println("width["+i+"]["+j+"]="+width[i][j]+"   longth["+i+"]["+j+"]="+longth[i][j]);
                //在找出了i的横向和纵向的1以后就可以开始计算了
                int count = 1;
                int minwidth = width[i][j];
                for (int k = i; k >= 0 && longth[k][j] != 0; k--) {
                    minwidth = Math.min(width[k][j],minwidth);
                    max = Math.max(count*minwidth,max);
                    count++;

                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode85 leetcode221 = new Leetcode85();
        String[][] a = new String[10][9];
        a[0] = new String[]{"1","0","1","0","0","1","1","1","0"};
        a[1] = new String[]{"1","1","1","0","0","0","0","0","1"};
        a[2] = new String[]{"0","0","1","1","0","0","0","1","1"};
        a[3] = new String[]{"0","1","1","0","0","1","0","0","1"};
        a[4] = new String[]{"1","1","1","0","1","0","0","1","0"};
        a[5] = new String[]{"0","1","1","1","1","1","1","0","1"};
        a[6] = new String[]{"1","0","1","1","1","0","0","1","0"};
        a[7] = new String[]{"1","1","1","0","1","0","0","0","1"};
        a[8] = new String[]{"0","1","1","1","1","0","0","1","0"};
        a[9] = new String[]{"1","0","0","1","1","1","0","0","0"};

        char[][] b = new char[10][9];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                b[i][j] = a[i][j].charAt(0);
            }
        }
        System.out.println(leetcode221.maximalRectangle(b));
    }
}
