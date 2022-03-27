package LeetCode;

public class Leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        String s = "";
        int l = strs.length;
        if (l == 0) {
            return s;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs[0].length() < 1) {
            return "";
        }

        int c = 1;
        while(true) {
            s = strs[0].substring(0,c);
            for (int i=1;i<l;i++) {
                if (strs[i].length() < s.length()) {
                    return s.substring(0,c-1);
                } else if (!strs[i].substring(0, c).equals(s)) {
                    if (c > 0) {
                        return s.substring(0,c-1);
                    }
                    return s;
                }
            }
            c++;
            if (c > strs[0].length()) {
                return s;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode14 l = new Leetcode14();
        String[] s = new String[]{"flower","flower","flower","flower"};
        System.out.println(l.longestCommonPrefix(s));
    }
}
