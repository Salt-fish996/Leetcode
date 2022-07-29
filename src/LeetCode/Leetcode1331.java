package src.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(res);
        int count = 1;
        map.put(res[0],1);
        count++;
        for (int i = 1; i < res.length; i++) {
            if (res[i] != res[i-1]) {
                map.put(res[i],count);
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        Leetcode1331 l = new Leetcode1331();
        System.out.println(Arrays.toString(l.arrayRankTransform(new int[]{37})));
    }
}
