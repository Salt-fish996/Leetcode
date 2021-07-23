package LeetCode;
/*
* 通过记录最大值得数组，在每次计算从某一个位置能够获得的最大值以后将其
* 保存到记录数组中，下次再需要计算从该位置开始能够获得的最大值的时候，就
* 直接在记录数组中取。
*
* 本解法采用的是动态规划，将其化为多个子问题求解*/
public class Leetcode198 {
    public int sum(int[] nums,int now, int[] big){
        //now代表当前位置
        if (now == nums.length - 1 || now == nums.length - 2) return nums[now];
        int max = 0;
        if (big[now] != -1) return big[now];
        for (int i = now+2; i < nums.length; i++) {
            int temp = sum(nums,i,big);
            max = Math.max(temp, max);
        }
        big[now] = max + nums[now];
        return max + nums[now];
    }
    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] big = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            big[i] = -1;
        }
        return Math.max(sum(nums,0,big),sum(nums,1,big));

    }

    public static void main(String[] args) {
        Leetcode198 leetcode198 = new Leetcode198();
        System.out.println(leetcode198.rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
        System.out.println(leetcode198.rob(new int[]{2,7,9,3,1}));
    }
}
