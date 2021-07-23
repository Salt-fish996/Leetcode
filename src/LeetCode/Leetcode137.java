package LeetCode;

import java.util.HashSet;

/**
 * @author hyy
 * @date 2020/3/15 10:43
 */
public class Leetcode137 {
    //使用HashSet存储数，将每一个数*3然后减去整个数组的和就等于2倍要求的数
    public int singleNumber(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
            sum += nums[i];
        }
        long setSum = 0;
        for (Integer i:hashSet
             ) {
            setSum += i;
        }
        return (int) ((setSum*3 - sum) / 2);
    }
}
