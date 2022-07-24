package src.LeetCode;

public class Leetcode53 {
    /*分析：
    * 使用p[i]来表示到p[i]的最大值
    * p[i]=max{p[i-1]+nums[i],nums[i]}**/
    public int maxSubArray(int[] nums) {

        int[] p = new int[nums.length];
        p[0] = Math.max(0,p[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            p[i] = Math.max(nums[i],p[i-1] + nums[i]);
            max = Math.max(p[i],max);
        }
        return max;

    }

    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(leetcode53.maxSubArray(a));
    }
}
