package src.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode377 {
    Map<Integer,Integer> count = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return combin(nums,target);
    }
    public int combin(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        if (this.count.containsKey(target)) {
            return this.count.get(target);
        }
        int sum = 0;
        for (int num : nums) {
            // 取这个数
            sum += combin(nums, target - num);
        }
        this.count.put(target,sum);
        return sum;
    }

    public static void main(String[] args) {
        Leetcode377 l = new Leetcode377();
        System.out.println(l.combinationSum4(new int[]{1,2,3},35));
    }
}
