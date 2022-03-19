package src.LeetCode;

import java.util.Arrays;

public class Leetcode2104 {
    public long subArrayRanges(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 对于一个数组[a,b,c，d]，那么相当a+b+c+  b-a+c-a+d-a + c-b+d-b + d-c
        Arrays.sort(nums);
        int l = nums.length;
        int v = 0;
        int count = l - 1;

        for (int i = 1; i < l; i++) {
            count = i * (l-i);
           v +=  (nums[i] - nums[i - 1]) *count;
//           count = count - 1 + l - i;
        }
        return v;
    }

    public static void main(String[] args) {
        Leetcode2104 l = new Leetcode2104();
        int []nums = new int[]{1,3,3};
        System.out.println(l.subArrayRanges(nums));
    }
}
