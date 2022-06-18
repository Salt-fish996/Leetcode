package src.LeetCode;

import java.util.HashMap;
import java.util.List;

public class Leetcode1759 {
    public int countHomogenous(String s) {
        long mod = 1000000007;
        char before = ' ';
        long count = 0;
        int res = 0;
        int nextCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == before) {
                nextCount += 1;
                count = (1 + (long) nextCount) * (long) nextCount /2;
            } else {
                res += (count % mod);
                count = 1;
                nextCount = 1;
                before = s.charAt(i);
            }
        }
        res += count % mod;
       return (int) (res % mod);
    }

    public static void main(String[] args) {
        Leetcode1759 l = new Leetcode1759();
        System.out.println(l.countHomogenous("zzzzz"));
    }
}
