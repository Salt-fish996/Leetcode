package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//地图分析，广度遍历bfs,通过
public class Leetcode1162 {

    public int maxDistance(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue1 = new LinkedList<>();//存储x
        Queue<Integer> queue2 = new LinkedList<>();//存储y
        Queue<Integer> queue3 = new LinkedList<>();//存储长度
        int max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    queue1.add(i);
                    queue2.add(j);
                    queue3.add(0);
                }
            }
        }
        while (!queue1.isEmpty()){
            int x = queue1.poll();
            int y = queue2.poll();
            int count = queue3.poll();


            if (x-1>=0  && grid[x-1][y] == 0){
                grid[x-1][y] = 1;
                queue1.add(x-1);
                queue2.add(y);
                queue3.add(count+1);
                max = Math.max(count+1,max);
            }
            if (x+1<n  && grid[x+1][y] == 0){
                grid[x+1][y] = 1;
                queue1.add(x+1);
                queue2.add(y);
                queue3.add(count+1);
                max = Math.max(count+1,max);
            }
            if (y-1>=0  && grid[x][y-1] == 0){
                grid[x][y-1] = 1;
                queue1.add(x);
                queue2.add(y-1);
                queue3.add(count+1);
                max = Math.max(count+1,max);
            }
            if (y+1<n  && grid[x][y+1] == 0){
                grid[x][y+1] = 1;
                queue1.add(x);
                queue2.add(y+1);
                queue3.add(count+1);
                max = Math.max(count+1,max);
            }
        }
        return max;

    }
}
