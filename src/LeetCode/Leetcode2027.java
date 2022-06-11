package src.LeetCode;

public class Leetcode2027 {
    public int minimumMoves(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == 'X') {
                res += 1;
                i += 2;
            }
        }
        return res;
    }
}
