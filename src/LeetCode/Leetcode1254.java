package src.LeetCode;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1254 {
    int[][] status;
    public int closedIsland(int[][] grid) {
        status = new int[grid.length][grid[0].length];
        int[][] or = new int[4][2];
        or[0] = new int[]{0,1};
        or[1] = new int[]{0,-1};
        or[2] = new int[]{1,0};
        or[3] = new int[]{-1,0};
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && status[i][j] == 0) {
                    boolean t = dfs(grid,i,j,or);
                     res +=  t?1:0;
                    System.out.println("("+i+","+j+")"+":"+Arrays.deepToString(this.status)+" "+t);
                }
            }
        }
        return res;
    }

    public boolean dfs(int[][] grid,int nowx,int nowy,int[][] or) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(nowx);
        qy.add(nowy);
        status[nowx][nowy] = 1;
        int[][] newStatus = new int[grid.length][grid[0].length];
        newStatus[nowx][nowy ]=1;
        while (!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            if (x == 0 || x == grid.length -1 || y == 0 || y == grid[0].length-1) {
                return false;
            }
            for (int i = 0; i < or.length; i++) {
                int tx = x + or[i][0];
                int ty = y + or[i][1];

                if (tx>= 0 && tx < grid.length && ty >= 0 && ty < grid[0].length) {
                    if (newStatus[tx][ty] == 0 && grid[tx][ty] == 0) {
                        status[tx][ty] = 1;
                        newStatus[tx][ty] = 1;
                        qx.add(tx);
                        qy.add(ty);
                    }
                }
            }
        }
        return true;
    }
}
