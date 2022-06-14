package src.LeetCode;

import java.util.Arrays;

public class Leetcode1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long mod = (long) (1e9+7);
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        // 计算任意两边的距离
        int upH = horizontalCuts.length > 0 ? horizontalCuts[0]:h;
        int bottomH = 0;
        int leftW = 0;
        long maxH = 0;
        long maxW = 0;
        int rightW = verticalCuts.length >0 ?verticalCuts[0]:w;
        for (int i = 0; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH,upH-bottomH);
            bottomH = upH;
            if (i == horizontalCuts.length - 1) {
                upH = h;
            } else {
                upH = horizontalCuts[i+1];
            }
        }
        maxH = Math.max(maxH,upH-bottomH);

        for (int j = 0; j < verticalCuts.length; j++) {
            maxW = Math.max(maxW,rightW-leftW);
            leftW = rightW;
            if (j == verticalCuts.length - 1) {
                rightW = w;
            } else {
                rightW = verticalCuts[j+1];
            }
        }
        maxW = Math.max(maxW,rightW-leftW);
        return (int) (maxH * maxW % (mod));
    }

    public static void main(String[] args) {
        Leetcode1465 l = new Leetcode1465();
        int[] h = new int[]{2};
        int[] w = new int[]{2};
        System.out.println(l.maxArea(1000000000,1000000000,h,w));
    }
}
