package src.LeetCode;

import java.util.*;

public class Leetcode768 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int[] arrSort = new int[arr.length];
        System.arraycopy(arr, 0, arrSort, 0, arr.length);
        Arrays.sort(arrSort);
        Map<Integer,Integer> set = new HashMap<>();
        Map<Integer,Integer> has = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.size() == 0 && has.size() == 0) {
                if (arr[i] == arrSort[i]) {
                    res++;
                    continue;
                }
            }
            int hasCount = has.getOrDefault(arrSort[i],0);
            if (hasCount > 0) {
                if (hasCount-1 == 0) {
                    has.remove(arrSort[i]);
                }else {
                    has.put(arrSort[i],hasCount-1);
                }
            }else {
                set.put(arrSort[i],set.getOrDefault(arrSort[i],0)+1);
            }

            if (set.containsKey(arr[i])) {
                hasCount = set.get(arr[i]);
                if (hasCount == 1) {
                    set.remove(arr[i]);
                } else {
                    set.put(arr[i],hasCount-1);
                }
            } else {
                hasCount = has.getOrDefault(arr[i],0);
                has.put(arr[i],hasCount+1);
            }
            if (has.size() == 0 && set.size() == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode768 l = new Leetcode768();
        System.out.println(l.maxChunksToSorted(new int[]{2,1,3,4,4}));
    }
}
