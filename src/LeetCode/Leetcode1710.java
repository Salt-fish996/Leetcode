package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        int max = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int s = Math.min(boxTypes[i][0], truckSize);
            max += s*boxTypes[i][1];
            truckSize -= s;
        }
        return max;
    }
}
