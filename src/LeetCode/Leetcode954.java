package src.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode954 {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        // 二倍数数组就是要数组中的每一个数都有其2倍数or是其中一个数的二倍
        Map<Integer,Integer> count = new HashMap<>();
        for (int k : arr) {
            if (!count.containsKey(k)) {
                count.put(k, 1);
            } else {
                count.put(k, count.get(k) + 1);
            }
        }

        for (int j : arr) {
            if (count.containsKey(j * 2) && count.containsKey(j)) {
                int v1 = count.get(j);
                int v2 = count.get(j * 2);
                if (v1 == 1) {
                    count.remove(j);
                } else {
                    count.put(j, v1 - 1);
                }
                if (v2 == 1) {
                    count.remove(j * 2);
                } else {
                    count.put(j * 2, v2 - 1);
                }
            }
        }
        return count.size() == 0;
    }
}
