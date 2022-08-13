package src.LeetCode;

import java.util.Arrays;

public class Leetcode1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];
        int sum = 0;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        res[0] = sum - nums[0] - (nums.length - 1) *nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = i*nums[i] - sums[i-1] +sum - sums[i] - (nums.length - i-1)*nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1685 l = new Leetcode1685();
        System.out.println(Arrays.toString(l.getSumAbsoluteDifferences(new int[]{1,4,6,8,10})));
    }
}
