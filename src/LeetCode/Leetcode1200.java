package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min,arr[i]-arr[i-1]);
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] == min) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i-1]);
                l.add(arr[i]);
                res.add(l);
            }
        }
        return res;
    }
}
