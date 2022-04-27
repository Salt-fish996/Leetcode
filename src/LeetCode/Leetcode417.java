package src.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode417 {

    // 可以优化，从边缘往上搜索，这样可以降低很多复杂度
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(heights,new int[m][n],i,j,m,n)) {
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    res.add(l);
                }
            }
        }
        return res;
    }

    // 标识能不能从(x,y)到达两边
    boolean dfs(int[][] heights, int[][] status,int x,int y, int m,int n) {

        boolean reachPO = false;
        boolean reachAO = false;
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        xq.add(x);
        yq.add(y);
        status[x][y] = 1;
        while (!xq.isEmpty()) {
            x = xq.poll();
            y = yq.poll();
            if (x == 0 || y == 0) {
                reachPO = true;
            }
            if (x == m-1 || y == n-1) {
                reachAO = true;
            }
            if (reachAO && reachPO){
                return true;
            }
            if (x - 1 >= 0 && heights[x-1][y] <= heights[x][y] && status[x-1][y] == 0) {
                status[x-1][y] = 1;
                xq.add(x-1);
                yq.add(y);
            }
            if (x + 1 < m && heights[x+1][y] <= heights[x][y] && status[x+1][y] == 0) {
                status[x+1][y] = 1;
                xq.add(x+1);
                yq.add(y);
            }
            if (y - 1 >= 0 && heights[x][y-1] <= heights[x][y] && status[x][y-1] == 0) {
                status[x][y-1] = 1;
                xq.add(x);
                yq.add(y-1);
            }
            if (y + 1 < n && heights[x][y+1] <= heights[x][y] && status[x][y+1] == 0) {
                status[x][y+1] = 1;
                xq.add(x);
                yq.add(y+1);
            }
        }
        return reachAO&&reachPO;
    }
}
