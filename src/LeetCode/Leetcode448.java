package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (true) {
                if (nums[i] == 0) {
                    break;
                }
                if (nums[i] - 1 != i) {
                    int t = nums[nums[i] - 1];
                    if (t == nums[i]) {
                        nums[i] = 0;
                        break;
                    }
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = t;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode448 l = new Leetcode448();
        System.out.println(l.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
