package src.LeetCode;

import java.util.Arrays;

public class Leetcode670 {
    public int maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray();
        char[] dp = new char[s.length];
        char max = '0';
        for (int i = s.length-1; i >= 0 ; i--) {
            max = (char) Math.max(max,s[i]);
            dp[i] = max;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] < dp[i]) {
                for (int j = s.length-1; j >i ; j--) {
                    if (s[j] == dp[i]) {
                        char t = s[i];
                        s[i] = s[j];
                        s[j] = t;
                        break;
                    }
                }
                break;
            }
        }
        return Integer.parseInt(String.copyValueOf(s));
    }

    public static void main(String[] args) {
        Leetcode670 l = new Leetcode670();
        System.out.println(l.maximumSwap(2736));
    }
}
