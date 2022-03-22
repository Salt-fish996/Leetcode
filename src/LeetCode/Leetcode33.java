package src.LeetCode;

public class Leetcode33 {
    public int search(int[] nums, int target) {
        // 找到降序的位置即可
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
