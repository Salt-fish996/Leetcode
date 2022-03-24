package src.LeetCode;

public class Leetcode661 {
    public int[][] imageSmoother(int[][] img) {
        // 对于一个点（i，j),他周围的8个点是（i,j-1),（i，j+1),(i-1,j),(i-1,j-1),(i-1,j+1),(i+1,j-1),(i+1,j),(i+1,j+1)
        int yl = img.length;
        int xl = img[0].length;
        int[][] res = new int[yl][xl];
        for (int i = 0; i < yl; i++) {
            for (int j = 0; j < xl; j++) {
                int count = 1;
                int sum = img[i][j];
                if (j - 1 >= 0) {
                    sum += img[i][j-1];
                    count++;
                }
                if (j+1 < xl) {
                    sum += img[i][j + 1];
                    count++;
                }
                if (i - 1 >= 0) {
                    sum += img[i-1][j];
                    count++;
                    if (j - 1 >= 0) {
                        sum += img[i-1][j-1];
                        count++;
                    }
                    if (j + 1 < xl) {
                        sum += img[i-1][j+1];
                        count++;
                    }
                }
                if (i+1 < yl) {
                    sum += img[i+1][j];
                    count++;
                    if (j - 1 >= 0) {
                        sum += img[i+1][j-1];
                        count++;
                    }
                    if (j + 1 < xl) {
                        sum += img[i+1][j+1];
                        count++;
                    }
                }
                res[i][j] = sum/count;
            }
        }
        return res;
    }
}
