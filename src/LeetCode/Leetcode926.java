package src.LeetCode;

public class Leetcode926 {
    public int minFlipsMonoIncr1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 使用dp[i][j]表示以 j 结尾的时候的最小翻转次数
        char[] arr = s.toCharArray();
        int[][] dp = new int[arr.length][2];
        if (arr[0] == '0') {
            dp[0][1] = 1;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1') {
                dp[i][0] = dp[i - 1][0]+1;
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0]);
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0]) + 1;
            }
            System.out.println("zero1: "+dp[i][0]+"one: "+dp[i][1]);
        }
        return Math.min(dp[arr.length-1][0],dp[arr.length-1][1]);
    }

    public int minFlipsMonoIncr(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 对1的优化
        char[] arr = s.toCharArray();
        int zero = 0;
        int one = 0;
        if (arr[0] == '0') {
            one = 1;
        } else {
            zero = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1') {
                one = Math.min(one,zero);
                zero +=1;
            } else {
                one = Math.min(one,zero)+1;
            }
            System.out.println("zero: "+zero+"one: "+one);
        }
        return Math.min(one,zero);
    }

    public static void main(String[] args) {
        Leetcode926 l = new Leetcode926();
        System.out.println(l.minFlipsMonoIncr1("00110"));
        System.out.println(l.minFlipsMonoIncr("00110"));
    }
}
