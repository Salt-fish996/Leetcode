package src.LeetCode;

/**
 * @author hyy
 * @date 2020/3/15 10:37
 */
public class Leetcode136 {
    public int singleNumber(int[] nums) {

        //使用抑或
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
