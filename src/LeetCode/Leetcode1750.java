package src.LeetCode;

public class Leetcode1750 {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        int n = s.length();
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return right - left+1;
            }
            while (true) {
                if (left + 1 < n && s.charAt(left + 1) == s.charAt(left)) {
                    left++;
                } else {
                    break;
                }
            }
            while (true) {
                if (right - 1 >= 0 && s.charAt(right-1) == s.charAt(right)) {
                    right--;
                } else {
                    break;
                }
            }
            if (s.charAt(left) != s.charAt(right)) {
                return right - left;
            } else {
                right--;
                left++;
            }
        }
        return right==left?1:0;
    }

    public static void main(String[] args) {
        Leetcode1750 l = new Leetcode1750();
        System.out.println(l.minimumLength("ca"));
    }
}
