package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Integer[] ns = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            ns[i] = nums[i];
        }


        Arrays.sort(ns, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int n1 = map.get(o1);
                int n2 = map.get(o2);
                if (n1 != n2) {
                   return n1-n2;
                }
                return o2-o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ns[i];
        }
        return nums;
    }
}
