package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] temp = new int[m];
        for (int i = 0; i < k; i++) {
            // 将最后一列进行存储
            for (int j = 0; j < m-1; j++) {
                temp[j+1] = grid[j][n-1];
            }
            temp[0] = grid[m-1][n-1];

            for (int j = 0; j < m; j++) {
                for (int l = n-2; l >=0 ; l--) {
                    grid[j][l+1] = grid[j][l];
                }
            }

            for (int j = 0; j < m; j++) {
                grid[j][0] =temp[j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < n; j++) {
               t.add(grid[i][j]);
            }
            res.add(t);
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "[[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]";
        String[] ss = s.split("],");
        int row = ss.length;
        int col = ss[0].split(",").length;
        int[][] grid = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] sss = ss[i].replace("[", "").replace("]", "").split(",");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(sss[j]);
            }
        }
        Leetcode1260 l = new Leetcode1260();
        System.out.println(l.shiftGrid(grid,4));
    }
}
