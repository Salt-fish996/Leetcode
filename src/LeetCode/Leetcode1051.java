package src.LeetCode;

import java.util.Arrays;

public class Leetcode1051 {
    public int heightChecker(int[] heights) {
        int[] newHeight = Arrays.copyOf(heights,heights.length);
        Arrays.sort(newHeight);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != newHeight[i]) {
                res++;
            }
        }
        return res;
    }
}
