package src.LeetCode;


import java.util.LinkedList;
import java.util.Queue;

public class Leetcode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 使用广度遍历
        int xMax = image.length;
        int yMax = image[0].length;
        int[][] status = new int[image.length][image[0].length];
        int[][] or = new int[4][2];
        or[0] = new int[]{0,1};
        or[1] = new int[]{0,-1};
        or[2] = new int[]{1,0};
        or[3] = new int[]{-1,0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(sr);
        qy.add(sc);
        status[sr][sc] = 1;
        int v = image[sr][sc];
        while (!qx.isEmpty()) {
            int nowx = qx.poll();
            int nowy = qy.poll();
            image[nowx][nowy] = color;
            for (int i = 0; i < or.length; i++) {
                if (nowx+or[i][0] < xMax && nowx+or[i][0] >=0 && nowy+or[i][1]>=0 && nowy+or[i][1] < yMax && status[nowx+or[i][0]][nowy+or[i][1]] == 0 && image[nowx+or[i][0]][nowy+or[i][1]] == v) {
                    qx.add(nowx+or[i][0]);
                    qy.add(nowy+or[i][1]);
                    status[nowx+or[i][0]][nowy+or[i][1]] = 1;
                }
            }
        }
        return image;
    }
}
