package src.LeetCode;

import java.util.Arrays;

public class Leetcode942 {
    // 参考答案
    public int[] diStringMatch(String s) {
        int n = s.length(), lo = 0, hi = n;
        int[] perm = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        perm[n] = lo; // 最后剩下一个数，此时 lo == hi
        return perm;
    }
    public static void main(String[] args) {
        Leetcode942 l = new Leetcode942();
        System.out.println(Arrays.toString(l.diStringMatch("IDID")));
    }
}
