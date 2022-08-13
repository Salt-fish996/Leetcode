package src.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        Set<Integer> has = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.size() == 0 && has.size() == 0) {
                if (arr[i] == i) {
                    res++;
                    continue;
                }
            }
            if (has.contains(i)) {
                has.remove(i);
            }else {
                set.add(i);
            }
            if (set.contains(arr[i])) {
                set.remove(arr[i]);
            } else {
                has.add(arr[i]);
            }
            if (has.size() == 0 && set.size() == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode769 l = new Leetcode769();
        System.out.println(l.maxChunksToSorted(new int[]{1,0,2,3,4}));
    }
}
