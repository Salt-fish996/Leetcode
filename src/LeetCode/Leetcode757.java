package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Leetcode757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0]-o1[0];
                }
                return o2[1]-o1[1];
            }
        });

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < intervals.length; i++) {
            int count = 0;
            for (Integer integer : set) {
                if (intervals[i][0] <= integer && intervals[i][1] >= integer) {
                    count++;
                }
            }
            count = 2-count;
            for (int j = intervals[i][0]; j <=intervals[i][1] ; j++) {
                if (count <= 0) {
                    break;
                }
                if (!set.contains(j)) {
                    set.add(j);
                    count--;

                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        String s = "[[1,2],[2,3],[2,4],[4,5]]";
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
        Leetcode757 l = new Leetcode757();
        System.out.println(l.intersectionSizeTwo(grid));
    }
}
