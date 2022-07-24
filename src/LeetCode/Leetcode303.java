package src.LeetCode;

import java.util.Arrays;

/**
 * @author hyy
 * @date 2019/12/4 17:18
 */
public class Leetcode303 {
    class NumArray {

        private int[] nums;
        public NumArray(int[] nums) {
            this.nums = Arrays.copyOfRange(nums,0,nums.length);
        }

        public int sumRange(int i, int j) {

            int n = nums.length;
            int count = 0;
            for (int k = i; k <=j ; k++) {
                count+=nums[k];
            }
            return count;
        }
    }
}
