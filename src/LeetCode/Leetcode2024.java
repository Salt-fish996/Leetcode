package src.LeetCode;

// 超时
public class Leetcode2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // dp[i][0][k]=dp[i-1][0][k]+1(a[i]='T'),dp[i-1][0][k-1]+1(a[i]='F')
        // dp[i][1][k]=dp[i-1][1][k]+1(a[i]='F'),dp[i-1][1][k-1]+1(a[i]='T')
        // 对于每一个位置有两个选择：1：变，2不变，使用深度优先
        char[] arr = answerKey.toCharArray();
        int[] dpT = new int[k+1];
        int[] dpF = new int[k+1];
        int max = 1;
        if (arr.length == 0) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = Math.min(i, k); j >= 0; j--) {
                if (j > i) {
                    dpF[j] = i;
                    dpT[j] = i;
                } else if (i == 0) {
                    if (arr[i] == 'T') {
                        dpT[0] = 1;
                        dpF[0] = 0;
                    } else {
                        dpT[0] = 0;
                        dpF[0]= 1;
                    }
                }else if (arr[i] == 'T') {
                    dpT[j] = dpT[j]+1;
                    if (j == 0) {
                        dpF[j] = 0;
                    } else {
                        dpF[j] = dpF[j - 1]+1;
                    }

                } else {
                    if (j == 0) {
                        dpT[j] = 0;
                    } else {
                        dpT[j] = dpT[j-1]+1;
                    }
                    dpF[j] = dpF[j]+1;
                }
                max = Math.max(dpT[j],max);
                max = Math.max(dpF[j],max);
            }
        }

        return max;
    }

    // 参考答案
    public int maxConsecutiveAnswers2(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    public int maxConsecutiveChar(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left++) != ch ? 1 : 0;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/solution/kao-shi-de-zui-da-kun-rao-du-by-leetcode-qub5/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        Leetcode2024 l = new Leetcode2024();
        System.out.println(l.maxConsecutiveAnswers("TTFTTTTTFT" , 1));
    }
}
