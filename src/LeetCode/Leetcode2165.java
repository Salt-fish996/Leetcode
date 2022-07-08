package src.LeetCode;

import java.util.Arrays;

public class Leetcode2165 {
    public long smallestNumber(long num) {
        char[] nums = Long.toString(num).toCharArray();

        long res = 0;
        int beginNoZero = 0;
        // 负数
        if (nums[0] == '-') {
            Arrays.sort(nums);
            for (int i = nums.length-1; i >=0; i--) {
                if (nums[i] == '-') {
                    continue;
                }
                res = res*10+nums[i]-'0';
            }
            return -1*res;
        }
        Arrays.sort(nums);
        // 正数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != '0') {
                beginNoZero = i;
                break;
            }
        }
        char t = nums[0];
        nums[0] = nums[beginNoZero];
        nums[beginNoZero] = t;
        for (int i = 0; i < nums.length; i++) {
            res = res*10+nums[i]-'0';
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode2165 l = new Leetcode2165();
        System.out.println(l.smallestNumber(310));
        System.out.println(l.smallestNumber(-7605));
    }
}
