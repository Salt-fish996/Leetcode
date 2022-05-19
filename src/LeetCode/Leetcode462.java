package src.LeetCode;

import java.util.Arrays;

public class Leetcode462 {
    public int minMoves2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
         long sum = 0;
        Arrays.sort(nums);
        int t = Math.abs(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            nums[i] +=t;
            sum+=nums[i];
        }
        long b = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min,sum- (long) (nums.length - i) *nums[i]+ (long) nums[i] *i-b);
            b += nums[i];
            sum = sum-nums[i];
        }
        return (int) min;
    }

    public static void main(String[] args) {
        Leetcode462 l = new Leetcode462();
        System.out.println(l.minMoves2(new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143}));
    }
}
