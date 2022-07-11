package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1834 {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int t1 = tasks[o1][1]-tasks[o1][0];
            int t2 = tasks[o2][1]-tasks[o2][0];
            if (t1 != t2) {
                return t1-t2;
            }
            if (o1 <= o2) {
                return 1;
            }
            return -11;
        });
        for (int i = 0; i < tasks.length; i++) {
            queue.add(i);

        }
        int[] res = new int[tasks.length];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "[[1,2],[2,4],[3,2],[4,1]]";
        String[] ss = s.split("],");
        int row = ss.length;
        int col = ss[0].split(",").length;
        int[][] grid = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] sss = ss[i].replace("[","").replace("]","").split(",");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(sss[j]);
            }
        }
        Leetcode1834 l = new Leetcode1834();

        System.out.println(Arrays.toString(l.getOrder(grid)));
    }
}
