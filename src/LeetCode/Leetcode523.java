package LeetCode;

/**
 * @author hyy
 * @date 2020/3/19 12:44
 */
public class Leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int result = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                result += nums[j];
                if (k != 0 &&result % k == 0) {
                    return true;
                } else if (k == 0 && result == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
