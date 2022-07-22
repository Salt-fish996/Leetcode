package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Leetcode452 {
    public int findMinArrowShots1(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0]!= o2[0]){
                return o2[0]-o1[0];
            }
            return o2[1] - o1[1];
        });

        Set<Integer> set = new HashSet<>();
        boolean has = false;
        for (int i = 0; i < points.length; i++) {
            has = false;
            for (Integer integer : set) {
                if (points[i][0] <= integer && points[i][1] >= integer) {
                    has = true;
                    break;
                }
            }
            if (!has) {
                set.add(points[i][0]);
            }
        }
        return set.size();
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0]!= o2[0]){
                return o2[0]-o1[0];
            }
            return o2[1] - o1[1];
        });

        int res = 1;
        int before = points[0][0];
        for (int i = 1; i < points.length; i++) {
                if (points[i][0] > before || points[i][1] < before) {
                    res++;
                    before = points[i][0];
                }
        }
        return res;
    }
}
