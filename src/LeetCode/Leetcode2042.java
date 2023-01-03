package src.LeetCode;

public class Leetcode2042 {
    public boolean areNumbersAscending(String s) {
        String[] ss = s.split(" ");
        int num = 0;
        for (int i = 0; i < ss.length; i++) {
            char c = ss[i].charAt(0);
            if (c >= '0' && c <= '9') {
                int cc = Integer.parseInt(ss[i]);
                if (cc < num) {
                    return false;
                } else {
                    num = cc;
                }
            }
        }
        return true;
    }
}
