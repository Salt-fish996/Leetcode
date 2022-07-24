package src.LeetCode;

public class Leetcode213 {
    public int sum(int[] nums,int now, int[] big,int begin){
        if (now >= nums.length) return 0;
        //now代表当前位置
        if (begin == 0 && now == nums.length - 1) return 0;//最后一个不能与第一个同时偷
        if (now == nums.length - 1 || now == nums.length - 2) return nums[now];

        int max = 0;
        if (big[now] != -1) return big[now];
        for (int i = now+2; i < nums.length; i++) {
            int temp = sum(nums,i,big,begin);
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
        int begin0 = sum(nums,0,big,0);
        for (int i = 0; i < nums.length; i++) {
            big[i] = -1;
        }
        int begin1 = sum(nums,1,big,1);
        for (int i = 0; i < nums.length; i++) {
            big[i] = -1;
        }
        int begin2 = sum(nums,2,big,2);
        return Math.max(Math.max(begin0,begin1),begin2);

    }

    public static void main(String[] args) {
        Leetcode213 leetcode213 = new Leetcode213();
        System.out.println(leetcode213.rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
        System.out.println(leetcode213.rob(new int[]{6,6,4,8,4,3,3,10}));
    }
}
