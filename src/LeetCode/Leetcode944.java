package src.LeetCode;

public class Leetcode944 {
    public int minDeletionSize(String[] strs) {
        if (strs.length == 0 || strs.length == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char a = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                char t = strs[j].charAt(i);
                if (t < a) {
                    count++;
                    break;
                }
                a = t;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode944 l = new Leetcode944();
        System.out.println(l.minDeletionSize(new String[]{"abc", "bce", "cae"}));
    }
}
