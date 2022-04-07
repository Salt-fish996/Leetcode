package src.LeetCode;

public class Leetcode796 {
    public boolean rotateString(String s, String goal) {
        StringBuilder t = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.substring(i) + t).equals(goal)) {
                return true;
            }
            t.append(s.charAt(i));
        }
        return false;
    }
}
