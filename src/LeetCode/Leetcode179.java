package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode179 {
    public String largestNumber(int[] nums) {
        Integer[] nn = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nn[i] = nums[i];
        }
        // 字典排序
        Arrays.sort(nn, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });
        if (nn[0] == 0) {
            return "0";
        }
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < nn.length; i++) {
            s.append(nn[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Leetcode179 l =new Leetcode179();
        System.out.println(l.largestNumber(new int[]{3,30,34,5,9}));
    }
}
