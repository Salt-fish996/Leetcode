package LeetCode;

public class Leetcode97 {
    public boolean check(String s1,String s2,String s3,int b1,int b2,int b3){
        boolean b = false;
        if (b1 == s1.length()){//如果已经把s1匹配完成
            return s2.substring(b2).equals(s3.substring(b3));
        }
        if (b2 == s2.length()){
            return s1.substring(b1).equals(s3.substring(b3));
        }
        if (s1.charAt(b1) == s3.charAt(b3)){
            b = check(s1,s2,s3, b1 + 1,b2, b3 + 1);
        }
        if (b) return true;
        if (s2.charAt(b2) == s3.charAt(b3)){
            return check(s1,s2,s3,b1,b2+1,b3+1);
        }
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {

        return check(s1,s2,s3,0,0,0);
    }


    //动态规划算法
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Leetcode97 leetcode97 = new Leetcode97();
        System.out.println(leetcode97.isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}
