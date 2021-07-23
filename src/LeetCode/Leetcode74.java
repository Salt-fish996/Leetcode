package LeetCode;

/**
 * @author hyy
 * @date 2019/8/5 21:00
 */
public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        try{
            if (matrix == null) return false;
            if (matrix.length == 0) return false;
            int width = matrix[0].length;
            int hign = matrix.length;

            int nowRow = 0;
            //从最后面开始寻找


            while (nowRow<hign && matrix[nowRow][width-1] <target){
                nowRow++;
            }
            int h = width-1;
            for (int j = 0; nowRow<hign&& j < width; j++) {
                if (target == matrix[nowRow][(j+h)/2]) return true;
                else if (target >matrix[nowRow][(j+h)/2]){
                    j = (j+h)/2+1;
                }else if (target <matrix[nowRow][(j+h)/2]){
                    h = (j+h)/2-1;
                }

            }
        }catch (Exception e){
            return false;
        }


        return false;

    }

    public static void main(String[] args) {
        int[][] a = new int[2][2];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 4;
        int[][] b = new int[1][1];
        b[0][0] = 3;
        Leetcode74 leetcode74 = new Leetcode74();
        System.out.println(leetcode74.searchMatrix(a,6));

    }
}
