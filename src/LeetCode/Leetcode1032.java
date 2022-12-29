package src.LeetCode;

import java.security.KeyStore;
import java.util.*;

public class Leetcode1032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (i == 0 || nums1[i] != nums1[i-1]) {
                count.put(nums1[i],count.getOrDefault(nums1[i],0)+1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (i == 0 || nums2[i] != nums2[i-1]) {
                count.put(nums2[i],count.getOrDefault(nums2[i],0)+1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            if (i == 0 || nums3[i] != nums3[i-1]) {
                count.put(nums3[i],count.getOrDefault(nums3[i],0)+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry :count.entrySet()) {
            if (entry.getValue() >= 2) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
