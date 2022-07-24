package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // 按照数组的第一个参数进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        for (int[] i:intervals
             ) {
           if (arr[0] == -1 && arr[1] == -1) {
               arr = i;
           } else {
               if (i[0] <= arr[1]) {
                   if (i[1] > arr[1]) {
                       arr[1] = i[1];
                   }
               } else {
                   res.add(arr);
                   arr = i;
               }
           }
        }
        if (arr[0] != -1) {
            res.add(arr);
        }
        int[][] r = new int[res.size()][2];
        for (int i =0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

}
