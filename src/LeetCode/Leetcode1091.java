package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//二进制矩阵中的最短路径,DFS,通过
public class Leetcode1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1)return -1;
        //记录数组
        int[][] visit = new int[m][n];
        //广度遍历
        Queue<Integer> queuex = new LinkedList<>();//行
        Queue<Integer> queuey = new LinkedList<>();//列
        Queue<Integer> count = new LinkedList<>();//记录步数
        queuex.add(0);
        queuey.add(0);
        count.add(1);
        visit[0][0] = 1;//1表示已经访问过了
        while (!queuex.isEmpty()){
            int x = queuex.poll();
            int y = queuey.poll();
            int countTemp = count.poll();
            if (x == m-1 && y == n-1) return countTemp;
            if (x+1>=0 && x+1 <m && grid[x+1][y] == 0 && visit[x+1][y] == 0){
                queuex.add(x+1);
                queuey.add(y);
                count.add(countTemp + 1);
                visit[x+1][y] = 1;
            }
            if (x+1>=0 && x+1 <m && y+1>=0&&y+1<n&& grid[x+1][y+1] == 0 && visit[x+1][y+1] == 0){
                queuex.add(x+1);
                queuey.add(y+1);
                count.add(countTemp + 1);
                visit[x+1][y+1] = 1;
            }
            if (x+1>=0 && x+1 <m && y-1>=0&&y-1<n&& grid[x+1][y-1] == 0 && visit[x+1][y-1] == 0){
                queuex.add(x+1);
                queuey.add(y-1);
                count.add(countTemp + 1);
                visit[x+1][y-1] = 1;
            }
            if (x-1>=0 && x-1 <m && grid[x-1][y] == 0 && visit[x-1][y] == 0){
                queuex.add(x-1);
                queuey.add(y);
                count.add(countTemp + 1);
                visit[x-1][y] = 1;
            }
            if (x-1>=0 && x-1 <m && y+1>=0&&y+1<n&& grid[x-1][y+1] == 0 && visit[x-1][y+1] == 0){
                queuex.add(x-1);
                queuey.add(y+1);
                count.add(countTemp + 1);
                visit[x-1][y+1] = 1;
            }
            if (x-1>=0 && x-1 <m && y-1>=0&&y-1<n&& grid[x-1][y-1] == 0 && visit[x-1][y-1] == 0){
                queuex.add(x-1);
                queuey.add(y-1);
                count.add(countTemp + 1);
                visit[x-1][y-1] = 1;
            }
            if ( y-1>=0&&y-1<n&&grid[x][y-1] == 0 && visit[x][y-1] == 0){
                queuex.add(x);
                queuey.add(y-1);
                count.add(countTemp + 1);
                visit[x][y-1] = 1;
            }
            if ( y+1>=0&&y+1<n&&grid[x][y+1] == 0 && visit[x][y+1] == 0){
                queuex.add(x);
                queuey.add(y+1);
                count.add(countTemp + 1);
                visit[x][y+1] = 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Leetcode1091 leetcode1091 = new Leetcode1091();
        int[][] g = new int[3][3];
        g[0] = new int[]{0,1,1};
        g[1] = new int[]{0,1,0};
        g[2] = new int[]{0,1,0};
        System.out.println(leetcode1091.shortestPathBinaryMatrix(g));
    }
}
