package src.LeetCode;

public class Leetcode1219 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    dfs(i,j,grid,grid[i][j]);
                }
            }
        }
        return this.max;
    }

    public void dfs(int x,int y,int[][] grid,int gold) {
        int rec = grid[x][y];
        this.max = Math.max(this.max,gold);
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
                int xn = x+this.dirs[i][0];
                int yn = y + this.dirs[i][1];
                if (xn >= 0 && xn < grid.length && yn >=0 && yn < grid[0].length && grid[xn][yn] != 0) {
                    dfs(xn,yn,grid,gold+grid[xn][yn]);
                }
        }
        grid[x][y] = rec;
    }
}
