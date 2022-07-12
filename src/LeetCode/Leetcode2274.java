package src.LeetCode;

import java.util.Arrays;

public class Leetcode2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int res = 0;
        Arrays.sort(special);
        if (special.length >0){
            res = special[0]-bottom;
            bottom = special[0];
        }
        for (int i = 1; i < special.length; i++) {
            res = Math.max(res,special[i]-bottom-1);
            bottom = special[i];
        }
        res = Math.max(res,top-bottom);
        return res;
    }

    public static void main(String[] args) {
        Leetcode2274 l = new Leetcode2274();
        System.out.println(l.maxConsecutive(1,49,new int[]{11,12,22,49,4,6}));
    }
}
