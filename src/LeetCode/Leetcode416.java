package LeetCode;

public class Leetcode416 {
//    public boolean check(List<Integer> set, int k, int sum){
//        if (sum<0)return false;
//        if (k == sum) return true;
//        List<Integer> set1 = new ArrayList<>(set);
//        for (Integer i:set
//             ) {
//            if (k + i <= sum){
//                set1.remove(i);
//
//                if (check(set1,k + i,sum)){
//                    return true;
//                }
//                set1.add(i);
//            }
//        }
//        return false;
//    }
//    public boolean canPartition(int[] nums) {
//
//        List<Integer> set = new ArrayList<>();
//        int sum = 0;
//        int n = nums.length;
//        int Max = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//            set.add(nums[i]);
//            Max = Math.max(Max,nums[i]);
//        }
//        //set.remove(new Integer(5));
//        //System.out.println(Arrays.toString(set.toArray()));
//
//        if (sum%2 != 0) return false;
//        return check(set,0,sum/2 - Max);
//
//    }


    //动态规划，01背包问题
    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum %2 != 0)return false;
        boolean[][] dp = new boolean[n][sum/2+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum/2+1; j++) {
                if (j == 0) dp[i][j] = true;
                else if (i == 0){
                    if (j == nums[i]) dp[i][j] = true;
                    else dp[i][j] = false;
                }else {
                    if (j > nums[i])
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                    else dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][sum/2];
    }
    private boolean dp(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return false;
        }
        if (nums[index] > target) {
            return false;
        } else {
            return dp(nums, index - 1, target - nums[index]) || dp(nums, index - 1, target);
        }
    }
    //递归
    public boolean canPartition2(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 == 1) {
            return false;
        }
        return dp(nums, nums.length - 1, total / 2);
    }



    public static void main(String[] args) {
        Leetcode416 leetcode416 = new Leetcode416();
        int[] a = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,99,1,100};
        System.out.println(leetcode416.canPartition(a));
    }
}
