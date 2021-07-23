package LeetCode;

//俄罗斯套娃信封问题,通过
public class Leetcode354 {
    public void swap(int[][] arr, int i,int j){
        int temp = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = temp;
        temp = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = temp;
    }
    public void sort(int[][] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j][0] < arr[j+1][0]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes.length == 0)return 0;
        int n = envelopes.length;
        //首先按照宽度排序，然后只需要找高度的最大递增自蓄力
        sort(envelopes);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (envelopes[j][1] > envelopes[i][1] && envelopes[j][0] != envelopes[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,dp[i]);
            System.out.print(dp[i]+" ");
        }
        return max;
    }
}
