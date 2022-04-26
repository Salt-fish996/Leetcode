package src.LeetCode;

public class Leetcode883 {
    public int projectionArea(int[][] grid) {

        int area = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int max1 = 0;
            int max2 =0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    area +=1;
                }
                max1 = Math.max(max1,grid[i][j]);
                max2 = Math.max(max2,grid[j][i]);
            }
            area += max1+max2;
        }
        return area;
    }
}
