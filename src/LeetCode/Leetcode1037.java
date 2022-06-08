package src.LeetCode;

public class Leetcode1037 {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0] - points[1][0];
        int x2 = points[0][0] - points[2][0];
        int y1 = points[0][1] - points[1][1];
        int y2 = points[0][1] - points[2][1];
        if (x1 == x2 && y1 == y2) {
            return false;
        }
        if (x1 == 0 && y1 == 0) {
            return false;
        }
        if (x2 == 0 && y2 == 0) {
            return false;
        }

        if (x1 == 0) {
            return x2 != 0;
        }
        if (x2 == 0) {
            return true;
        }
        return (double)y1/(double)x1 != (double)y2/(double)x2;
    }
}
