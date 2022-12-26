package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        ArrayList<Integer> res = new ArrayList<>();
        if (security.length == 0) {
            return res;
        }
        int[] reduce = new int[security.length];
        int[] incr = new int[security.length];
        int n = security.length;
        reduce[0] = 1;
        incr[security.length - 1] = 1;
        for (int i = 1; i < security.length; i++) {
            if (security[i] <= security[i-1]) {
                reduce[i] = reduce[i-1]+1;
            } else {
                reduce[i] = 1;
            }
            if (security[n - i -1] <= security[n-i]) {
                incr[n - i -1] = incr[n - i]+1;
            } else {
                incr[n-i-1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (time == 0 || (i - 1 >=0 && reduce[i-1] >= time && i < n -1 && incr[i+1] >= time && reduce[i] != 1 && incr[i] != 1)) {
                res.add(i);
            }
        }
        System.out.println(Arrays.toString(reduce));
        System.out.println(Arrays.toString(incr));
        return res;
    }

    public static void main(String[] args) {
        Leetcode2100 l = new Leetcode2100();
        System.out.println(l.goodDaysToRobBank(new int[]{2,0,5,3,4},1));
    }
}
