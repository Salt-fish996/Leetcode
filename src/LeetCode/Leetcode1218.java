package src.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

public class Leetcode1218 {
    public int longestSubsequence(int[] arr, int difference) {
        if (arr.length <= 1) {
            return arr.length;
        }
        Map<Integer,Integer> map = new HashMap<>();
        // dp[i]=dp[j]+1(arr[i]-arr[j]=difference)
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int t = map.getOrDefault(arr[i]-difference,0)+1;
            map.put(arr[i],t);
            max = Math.max(max,t);

        }
        return max;
    }

    public static void main(String[] args) {
        Leetcode1218 l = new Leetcode1218();
        System.out.println(l.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1},-2));
    }
}
