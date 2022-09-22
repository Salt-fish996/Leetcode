package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0],i);
        }

        for (int i = 0; i < arr.length;) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int index = map.get(arr[i]);
            i++;
            for (int j = 1; j < pieces[index].length; j++) {
                if (pieces[index][j] == arr[i]) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
