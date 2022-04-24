package src.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode910 {
    // 参考了答案，又是脑筋急转弯
        public int smallestRangeII(int[] A, int K) {
            int N = A.length;
            Arrays.sort(A);
            int ans = A[N-1] - A[0];

            for (int i = 0; i < A.length - 1; ++i) {
                int a = A[i], b = A[i+1];
                int high = Math.max(A[N-1] - K, a + K);
                int low = Math.min(A[0] + K, b - K);
                ans = Math.min(ans, high - low);
            }
            return ans;
        }
    public static void main(String[] args) {
        Leetcode910 l = new Leetcode910();
        System.out.println(l.smallestRangeII(new int[]{0,10},2));
    }
}
