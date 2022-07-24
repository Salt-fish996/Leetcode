package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/17 13:46
 */
//最长涓流子数组，通过
public class Leetcode978 {
    //使用dp[i]来表示当前位置前的最长涓流子数组的长度dp[0]=1
    //dp[i]=A[i-1]>A[i-2]&&A[i-1]>A[i]+dp[i-1] || A[i-1]<A[i-2]&&A[i]>A[i-1] +dp[i-1] || 2
    public int maxTurbulenceSize(int[] A) {

        int n = A.length;
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (i == 1){
                //如果现在是第二个元素，那么要特殊处理
                if (A[i] != A[i-1]){
                    dp[i] = 2;
                }else {
                    dp[i] = 1;
                }
                max = Math.max(max,dp[i]);
            }else {
                //需要计算i-1
                if (A[i - 1] > A[i - 2] && A[i - 1] > A[i]){
                    dp[i] = dp[i - 1] + 1;
                    max = Math.max(max,dp[i]);
                }else if (A[i - 1] < A[i - 2] && A[i - 1] < A[i]){
                    dp[i] = dp[i - 1] + 1;
                    max = Math.max(max,dp[i]);
                }else {
                    if (A[i] != A[i-1]){
                        dp[i] = 2;
                    }else {
                        dp[i] = 1;
                    }
                    max = Math.max(max,dp[i]);

                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return max;
    }


    public static void main(String[] args) {
        Leetcode978 leetcode978 = new Leetcode978();
        int[] a = new int[]{9,9,9,9,9,8,10};
        System.out.println(leetcode978.maxTurbulenceSize(a));
    }
}
