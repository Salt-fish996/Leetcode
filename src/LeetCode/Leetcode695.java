package LeetCode;

/**
 * @author hyy
 * @date 2020/3/15 10:53
 */
//岛屿的最大面积,通过
public class Leetcode695 {

    public int dfs(int[][] grid, int row, int col) {
        //(row，cow)代表开始位置
        if (grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int result = 1;
        //向四个方向
        if (row + 1 < grid.length) {
            result += dfs(grid, row + 1, col);
        }
        if (row -1 >= 0) {
            result += dfs(grid, row -1,col);
        }

        if (col + 1 < grid[0].length) {
            result += dfs(grid, row, col + 1);
        }
        if (col -1 >= 0) {
            result += dfs(grid,row, col - 1);
        }
        return result;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        //使用深度优先搜索
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0){
                    max = Math.max(max, dfs(grid, i ,j));
                }
            }
        }
        return max;
    }
}
