package src.LeetCode;

public class Leetcode443 {
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        char start = chars[0];
        int sum = 0;
        int count = 1;
        int res =0;
        for (int i = 1; i < chars.length; i++) {
            if (start == chars[i]) {
                count++;
            } else {
                chars[sum++] = start;
                if (count != 1)  {
                    char[] c = Integer.toString(count).toCharArray();
                    for (int j = 0; j < c.length; j++) {
                        chars[sum++] = c[j];
                    }
                    res += 1+c.length;
                } else {
                    res += 1;
                }
                count=1;
                start = chars[i];
            }
        }
        chars[sum++] = start;
        if (count != 1)  {
            char[] c = Integer.toString(count).toCharArray();
            for (int j = 0; j < c.length; j++) {
                chars[sum++] = c[j];
            }
            res += 1+c.length;
        } else {
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode443 l = new Leetcode443();
        System.out.println(l.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
