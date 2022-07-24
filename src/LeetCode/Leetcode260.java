package src.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode260 {
    public int[] singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        int[] result = new int[2];
        int count = 0;
        for (int a:set
        ) {
            result[count++] = a;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,2,1,3,2,5};
        Leetcode260 leetcode260 = new Leetcode260();
        System.out.println(leetcode260.singleNumber(a));
    }
}
