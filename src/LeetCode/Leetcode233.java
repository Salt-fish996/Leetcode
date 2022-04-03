package src.LeetCode;

import java.util.HashMap;

public class Leetcode233 {
    // 超时
    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            char[] s = Integer.toString(i).toCharArray();
            for (char c : s) {
                if (c == '1') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode233 l = new Leetcode233();
        System.out.println(l.countDigitOne(100));
    }
}
