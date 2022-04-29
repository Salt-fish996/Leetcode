package src.LeetCode;

import java.util.*;

public class Leetcode1338 {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (!map.containsKey(arr[i])) {
                l.add(arr[i]);
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        l.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return map.get(o1)-map.get(o2);
            }
        });
        int res = 0;
        int sum = 0;
        for (int i = l.size()-1; true; i--) {
            sum += map.get(l.get(i));
            res++;
            if (sum >= arr.length / 2) {
                return res;
            }
        }
    }
}
