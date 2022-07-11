package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode873 {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            indices.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = indices.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/solution/zui-chang-de-fei-bo-na-qi-zi-xu-lie-de-c-8trz/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    public static void main(String[] args) {
        Leetcode873 l = new Leetcode873();
        System.out.println(l.lenLongestFibSubseq(new int[]{2,4,5,6,7,8,11,13,14,15,21,22,34}));
    }
}
