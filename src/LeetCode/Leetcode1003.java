package src.LeetCode;

public class Leetcode1003 {
    public boolean isValid(String s) {
        String t = "abc";
        while (s.length() > 0) {
            String tmp = s;
            s = s.replace(t,"");
            if (s.equals(tmp)) {
                return false;
            }
        }
        return true;
    }
}
