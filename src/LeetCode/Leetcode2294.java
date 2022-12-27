package src.LeetCode;

import java.util.Arrays;

public class Leetcode2294 {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int curMin = 0;
        if (nums.length == 0) {
            return res;
        }
        curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curMin == Integer.MIN_VALUE) {
                curMin = nums[i];
            }
            if (nums[i] - curMin > k) {
                res++;
                curMin = nums[i];
            }
        }
        return res+1;
    }
}
