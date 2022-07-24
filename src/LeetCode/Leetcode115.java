package src.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author hyy
 * @date 2019/11/17 14:25
 */
public class Leetcode115 {
    /**
     * dp[i][j]表示字符串S中前i位包含字符串前j位的字符串多少次
     * 如果S[i] = T[j],那么dp[i][j]=dp[i-1][j-1] + dp[i-1][j]
     * 否则dp[i][j]=dp[i-1][j]*/
    public int numDistinct2(String s, String t) {

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j];
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m][n];
    }




    //dfs+记忆回溯,通过
    public int dfs(String s, String t, int indexs, int indext, HashMap<String,Integer> hashMap){
        if (indext == t.length() - 1){
            //已经匹配到最后一个字符了
            int count = 0;
            for (int i = indexs; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(indext)){
                    count++;
                }
            }
            return count;
        }

        String key = s.substring(indexs) + " " + t.substring(indext);
        if (hashMap.get(key) != null){
            return hashMap.get(key);
        }

        if (indexs == s.length()){
            return 0;
        }

        int count = 0;
        for (int i = indexs; i < s.length(); i++) {
            //如果s的第i位与t的第indext位相同，那么进行递归计算
            if (s.charAt(i) == t.charAt(indext)){
                count += dfs(s,t,i+1,indext + 1,hashMap);
            }
        }
        //放入hashMap进行记忆
        hashMap.put(key,count);
        return count;
    }
    public int numDistinct(String s, String t) {

        HashMap<String,Integer> hashMap = new HashMap<>();
        return dfs(s,t,0,0,hashMap);
    }


    public static void main(String[] args) {
        Leetcode115 leetcode115 = new Leetcode115();
        //System.out.println(leetcode115.numDistinct("rabbbit","rabbit"));
        System.out.println(leetcode115.numDistinct2("babgbag","bag"));
    }
}
