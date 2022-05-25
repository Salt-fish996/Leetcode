package src.LeetCode;

import java.util.Map;

public class Leetcode467 {
    public int findSubstringInWraproundString(String p) {
        // 使用dp[i]表示以字母'a'+i结尾的子串的个数
        char[] arr = p.toCharArray();
        int start = arr[0]-'a';
        int k = 1;
        int[] dp = new int[26];
        dp[start] = k;
        for (int i = 1; i < p.length(); i++) {
            if ((arr[i]+26-arr[i-1]) % 26 == 1) {
                k++;
            } else {
                k = 1;
            }
            dp[arr[i] -'a'] = Math.max(dp[arr[i]-'a'],k);
        }
        int res = 0;
        for (int j : dp) {
            res += j;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode467 l = new Leetcode467();
        System.out.println(l.findSubstringInWraproundString("zab"));
    }
}
