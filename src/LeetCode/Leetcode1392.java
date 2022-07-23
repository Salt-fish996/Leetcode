package src.LeetCode;

public class Leetcode1392 {
    // 超时
    public String longestPrefix(String s) {
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            String t = s.substring(0,i);
            if (s.startsWith(t) && s.endsWith(t)) {
                res = s;
                continue;
            }
            break;
        }
        return res;
    }
}
