package src.LeetCode;

import java.util.TreeSet;
//通过
public class Leetcode220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {



        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + k &&j<n; j++) {

                if (Math.abs((long)nums[i] - (long)nums[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }

}
