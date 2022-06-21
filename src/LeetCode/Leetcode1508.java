package src.LeetCode;

import java.util.Arrays;

public class Leetcode1508 {
        public int rangeSum(int[] nums, int n, int left, int right) {
            final int MODULO = 1000000007;
            int sumsLength = n * (n + 1) / 2;
            int[] sums = new int[sumsLength];
            int index = 0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < n; j++) {
                    sum += nums[j];
                    sums[index++] = sum;
                }
            }
            Arrays.sort(sums);
            int ans = 0;
            for (int i = left - 1; i < right; i++) {
                ans = (ans + sums[i]) % MODULO;
            }
            return ans;
        }

}
