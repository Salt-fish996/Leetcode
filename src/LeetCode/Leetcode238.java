package LeetCode;

/**
 * @author hyy
 * @date 2019/9/6 16:19
 */
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {

        int[] before = new int[nums.length];//
        int[] after = new int[nums.length];

        int n = nums.length;
        before[0] = 1;
        after[n-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            before[i] = before[i-1]*nums[i-1];
        }

        for (int i = n-2; i >=0; i--) {
            after[i]  = after[i+1]*nums[i+1];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = before[i] * after[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        Leetcode238 l = new Leetcode238();
        l.productExceptSelf(a);
    }
}
