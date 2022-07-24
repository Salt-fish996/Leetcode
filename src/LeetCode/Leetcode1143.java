package src.LeetCode;

public class Leetcode1143 {
    //深度遍历
    public int dfs(String str1, String str2, int index1, int index2, int length){
        if (index1 >= str1.length() || index2 >= str2.length()) return length;
        int max = length;

        if (str1.charAt(index1) == str2.charAt(index2)){
            max = Math.max(dfs(str1,str2,index1 + 1,index2 + 1,length + 1),max);
        }

        max = Math.max(dfs(str1,str2,index1 + 1,index2,length),max);
        max = Math.max(dfs(str1,str2,index1,index2 + 1,length),max);
        return max;
    }
    public int longestCommonSubsequence1(String text1, String text2) {

        return dfs(text1,text2,0,0,0);
    }


    //动态规划
    //使用dp[i][j]表示text1的前i个字符和text2的前j个字符的最长公共子序列
    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                    if (text1.charAt(i) == text2.charAt(j)){
                        if (j >= 1 && i>=1)
                           dp[i][j] = dp[i - 1][j - 1] + 1;
                        else
                            dp[i][j] = 1;
                    }

                    if (i >= 1){
                        if (j >= 1)
                            dp[i][j] = Math.max(dp[i][j],Math.max(dp[i - 1][j], dp[i][j - 1]));
                        else
                            dp[i][j] = Math.max(dp[i][j],dp[i - 1][j]);
                    }else{
                        if (j>= 1)
                        dp[i][j] = Math.max(dp[i][j],dp[i][j - 1]);
                    }

                }
        }
        return dp[len1 - 1][len2 - 1];
    }
    public static void main(String[] args) {
        Leetcode1143 leetcode1143 = new Leetcode1143();
        System.out.println(leetcode1143.longestCommonSubsequence("pmjghexybyrgzczy",
                "hafcdqbgncrcbihkd"));
    }
}
