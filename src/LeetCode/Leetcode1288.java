package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            boolean needRemove = false;
            // 往后遍历
            for (int j = i+1; j < intervals.length; j++) {
               if (intervals[j][1] >= intervals[i][1]) {
                   needRemove = true;
                   break;
               }
            }
            if (!needRemove) {
               res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "[[1,4],[2,3]]";
        String[] ss = s.split("],");
        int row = ss.length;
        int col = ss[0].split(",").length;
        int[][] grid = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] sss = ss[i].replace("[", "").replace("]", "").split(",");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(sss[j]);
            }
        }
        Leetcode1288 l = new Leetcode1288();
        System.out.println(l.removeCoveredIntervals(grid));
    }
}
