package src.LeetCode;

public class Leetcode868 {
    public int binaryGap(int n) {
        char[] s = Integer.toBinaryString(n).toCharArray();
        int before = -1;
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '1') {
                if (before == -1) {
                    before = i;
                }else {
                    res = Math.max(res,i -before);
                    before = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode868 l = new Leetcode868();
        System.out.println(l.binaryGap(22));
    }
}
