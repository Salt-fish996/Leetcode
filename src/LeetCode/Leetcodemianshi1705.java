package src.LeetCode;

import java.util.Arrays;

public class Leetcodemianshi1705 {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        if (n <= 1) {
            return new String[]{};
        }
        int[] dp = new int[n];
        char c = array[0].charAt(0);
        // 使用dp[i]表示前i个数的数字
        dp[0] =  ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))?1:0;
        for (int i = 1; i < n; i++) {
            c = array[i].charAt(0);
            dp[i] = dp[i-1]+(((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))?1:0);
        }
        int max = 0;
        int begin = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                if (max >= j-i+1) {
                    break;
                }
                if ((dp[j]-(i > 0 ?dp[i-1]:0))*2 == j-i+1) {
                        max = j-i+1;
                        begin = i;
                        end=j;
                    break;
                }
            }
        }
        String[] res = new String[end-begin+1];
        for (int i = begin; i <= end; i++) {
            res[i-begin] = array[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcodemianshi1705 l = new Leetcodemianshi1705();
        System.out.println(Arrays.toString(l.findLongestSubarray(new String[]{"A","A","B"})));
    }
}
