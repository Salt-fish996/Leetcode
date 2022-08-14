package src.LeetCode;

public class Leetcode1422 {
    public int maxScore(String s) {
      int left = 0;
      int right = 0;
      int max = 0;
      int n = s.length();
        for (int i = 1; i < n; i++) {
            left = 0;
            right = 0;
            for (int j = 0; j < n; j++) {
                left += j<i&&s.charAt(j) == '0'?1:0;
                right += j>=i&&s.charAt(j) == '1'?1:0;
            }
            max = Math.max(max,left+right);
        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode1422 l = new Leetcode1422();
        System.out.println(l.maxScore("011101"));
    }
}
