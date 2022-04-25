package src.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Leetcode398 {
    class Solution {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Random r = new Random();
        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
               List<Integer> l = map.getOrDefault(nums[i], new ArrayList<Integer>() {});
                l.add(i);
               map.put(nums[i],l);
            }
        }

        public int random(int len) {
           return r.nextInt(len);
        }

        public int pick(int target) {
            List<Integer> l = map.get(target);
            return l.get(this.random(l.size()));
        }
    }
}
