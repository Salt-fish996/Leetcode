package src.LeetCode;

public class Leetcode806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];
        int count = 0;
        int row = 1;
        for (int i = 0; i < s.length(); i++) {
           int curSize = widths[s.charAt(i)-'a'];
           if (count + curSize > 100) {
               row++;
               count = curSize;
           } else {
               count+= curSize;
           }
        }
        res[0] = row;
        res[1] = count;
        return res;
    }
}
