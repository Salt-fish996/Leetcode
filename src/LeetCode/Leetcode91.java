package src.LeetCode;

/**
 * @author hyy
 * @date 2020/3/18 10:31
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
//通过
public class Leetcode91 {
    public int numDecodings(String s) {

        //使用dp[i]表示前i个字符有多少表示方式
        //dp[i+1]=dp[i] + (s.charAt(length - i, length) <= 26 ?(dp[i-1]):0)
        int[] dp = new int[s.length() + 1];

        if (s.length() >0 && s.charAt(0) != '0'){
            dp[0] = 1;
            dp[1] = 1;
        } else {
            dp[0] = 0;
            dp[1] = 0;
        }

        for (int i = 2; i <= s.length(); i++) {
            String substring = s.substring(i - 2, i);
            if (Integer.parseInt(substring) == 0){
                dp[i] = 0;
            } else {
                if (Integer.parseInt(substring) <= 26 && s.charAt(i - 2) != '0') {
                    //System.out.println(s.substring(i - 2, i));
                    dp[i] += dp[i - 2];
                }
                if (s.charAt(i - 1) != '0') {
                    dp[i] += dp[i - 1];
                }
            }


        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Leetcode91 leetcode91 = new Leetcode91();
        System.out.println(leetcode91.numDecodings("101011"));
    }
}
