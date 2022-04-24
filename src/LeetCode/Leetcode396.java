package src.LeetCode;

import java.util.Arrays;

public class Leetcode396 {
    // 超时
    public int maxRotateFunction1(int[] nums) {
        int[] twoSums = new int[nums.length*2];
        for (int i = 0; i < nums.length+2; i++) {
            twoSums[i] = nums[i%nums.length];
        }

        int max =  Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < i+nums.length; j++) {
                sum += twoSums[j]*(j-i);
            }
            max = Math.max(sum,max);
        }
        return max;
    }

    // 参考答案
    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

}
