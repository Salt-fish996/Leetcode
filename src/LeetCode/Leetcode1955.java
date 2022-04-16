package src.LeetCode;

public class Leetcode1955 {
    public int countSpecialSubsequences(int[] nums) {
        if (nums.length < 3)  {
            return 0;
        }
        // 使用dp[i][j]表示前i位以j结尾的数目的个数
        long[][] dp = new long[nums.length][3];
        dp[0][0] = nums[0] == 0?1:0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][nums[i]] = (long) ((dp[i-1][nums[i]]*2 + (nums[i]>0?dp[i-1][nums[i]-1]:1))%(1e9 + 7));
            for (int j = 0; j < 3; j++) {
                if (j != nums[i]) {
                    dp[i][j] = (long) (dp[i-1][j]%(1e9 + 7));
                }
            }
//            switch (nums[i]) {
//                case 0:
//                    dp[i][0] = (long) ((dp[i-1][0]*2 + 1)%(1e9 + 7));
//                    dp[i][1] = (long) (dp[i-1][1]%(1e9 + 7));
//                    dp[i][2] = (long)(dp[i-1][2]%(1e9 + 7));
//                    break;
//                case 1:
//                    dp[i][0] = (long)(dp[i-1][0]%(1e9 + 7));
//                    dp[i][1] = (long)(dp[i-1][1]*2+dp[i-1][0]%(1e9 + 7));
//                    dp[i][2] = (long)(dp[i-1][2]%(1e9 + 7));
//                    break;
//                case 2:
//                    dp[i][0] = (long)(dp[i-1][0]%(1e9 + 7));
//                    dp[i][1] = (long)(dp[i-1][1]%(1e9 + 7));
//                    dp[i][2] = (long)(dp[i-1][2]*2+dp[i-1][1]%(1e9 + 7));
//                    break;
//            }
        }
        return (int) (dp[nums.length-1][2]%(1e9 + 7));
    }

    public static void main(String[] args) {
        Leetcode1955 l = new Leetcode1955();
        System.out.println(l.countSpecialSubsequences(new int[]{0,1,2,0,1,2}));
    }
}
