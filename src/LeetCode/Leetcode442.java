package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            while (nums[i]!= i + 1 && nums[i] != -1) {
                if (nums[nums[i]-1] == nums[i]) {
                    res.add(nums[i]);
                    nums[i] = -1;
                } else {
                    int t = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = t;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode442 l = new Leetcode442();
        System.out.println(l.findDuplicates(new int[]{13,8,5,3,20,12,3,20,5,16,9,19,12,11,13,19,11,1,10,2}));
    }
}
