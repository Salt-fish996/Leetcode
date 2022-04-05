package src.LeetCode;

import java.util.ArrayList;

public class Leetcode547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if (n == 1) {
            return 1; 
        }
        int[] status = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (status[i] == 0) {
                res++;
                status[i] = 1;
                this.dfs(isConnected, status, i, n);
            }
        }
        return res;
    }

    // 深度优先搜索,将从（x,y)开始能够到达的结点标记为status=1
    public void dfs(int[][] isConnected, int[] status, int x, int n) {

        ArrayList<Integer> need = new ArrayList<>();
        // 到达点y的时候，所有与点y相连的都应该处理一遍
        for (int i = 0; i < n; i++) {
            if (isConnected[x][i] == 1 && status[i] == 0 && x!=i) {
                status[i] = 1;
                need.add(i);
            }
        }
        for (int i = 0; i < need.size(); i++) {
            this.dfs(isConnected,status,need.get(i),n);
        }
    }

    public static void main(String[] args) {
        Leetcode547 l = new Leetcode547();
        int[][] arr = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(l.findCircleNum(arr));
    }
}
