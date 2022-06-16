package src.LeetCode;

import java.util.Arrays;

public class Leetcode532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        boolean has = false;
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) {
                    res += has ?0:1;
                    has = true;
                } else {
                    has = false;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 以 i 为右节点
            for (int j = i-1; j >= 0; j--) {
                if (j < i-1 &&  nums[j+1] ==  nums[j]) {
                    continue;
                }
                if (nums[i] - nums[j] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode532 l = new Leetcode532();
        System.out.println(l.findPairs(new int[]{3, 1, 4, 1, 5},0));
    }
}
