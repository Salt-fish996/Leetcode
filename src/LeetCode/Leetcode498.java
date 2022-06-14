package src.LeetCode;

import java.util.Arrays;

public class Leetcode498 {
    int[] res;
    int index;
    public int[] findDiagonalOrder(int[][] mat) {
        this.res = new int[mat.length*mat[0].length];
        index = 0;
        dpf(mat,0,0,true);
        return res;
    }
    public void dpf(int[][] mat, int x,int y, boolean isUp){
        res[index] = mat[x][y];
        index++;
        if (x == mat.length-1 && y == mat[0].length - 1) {
            return;
        }
        // 向上
        if (isUp) {
            if (x - 1 >= 0 && y + 1 < mat[0].length) {
                dpf(mat,x-1,y+1, true);
                return;
            }
            if (y+1 < mat[0].length) {
                dpf(mat,x,y+1,false);
                return;
            }
            dpf(mat,x+1,y, false);
            return;
        }

        // 向下
        if (x + 1 < mat.length && y -1 >=0) {
            dpf(mat,x+1,y-1, false);
            return;
        }
        if (x + 1 >= mat.length) {
            dpf(mat,x,y+1,true);
            return;
        }
        dpf(mat,x+1,y, true);
    }

    public static void main(String[] args) {
        Leetcode498 l = new Leetcode498();
        String s = "[[1,2,3],[4,5,6],[7,8,9]]";
        String[] ss = s.split("],");
        int row = ss.length;
        int col = ss[0].split(",").length;
        int[][] grid = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] sss = ss[i].replace("[","").replace("]","").split(",");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(sss[j]);
            }
        }
        System.out.println(Arrays.toString(l.findDiagonalOrder(grid)));
    }
}
