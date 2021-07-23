package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode200 {

    /*
    * 采用广度遍历的方式，计算一共需要访问多少次才能够访问完所有的1*/
    public void dfs(char[][] grid, int x, int y){
        int[] ori = {-1,1};
        grid[x][y] = '0';
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        while (!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

            for (int i = 0; i < 2; i++) {
                    if (x+ori[i]>=0 &&x+ori[i]<grid.length && grid[x+ori[i]][y] == '1'){
                        queue.add(x+ori[i]);
                        queue.add(y);
                        grid[x+ori[i]][y] = '0';
                    }
            }
            for (int i = 0; i < 2; i++) {
                if (y+ori[i]>=0 &&y+ori[i]<grid[0].length && grid[x][y+ori[i]] == '1'){
                    queue.add(x);
                    queue.add(y+ori[i]);
                    grid[x][y+ori[i]] = '0';
                }
            }
        }

    }
    public int numIslands(char[][] grid) {

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] g = new char[4][5];
        g[0]="11110".toCharArray();
        g[1]="11010".toCharArray();
        g[2]="11000".toCharArray();
        g[3]="00000".toCharArray();
        Leetcode200 leetcode200 = new Leetcode200();
        System.out.println(leetcode200.numIslands(g));
    }
}
