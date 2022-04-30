package src.LeetCode;

import java.util.Arrays;

public class Leetcode908 {
    // 找到最大值和最小值就可以了
    public int smallestRangeI1(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] - nums[0] <= 2*k) {
            return 0;
        }
       return nums[nums.length - 1] - 2*k - nums[0];
    }

    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return Math.max(max - min -2*k,0);
    }
}
