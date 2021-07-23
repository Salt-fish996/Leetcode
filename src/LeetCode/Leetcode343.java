package LeetCode;

public class Leetcode343 {
    /**给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

     示例 1:

     输入: 2
     输出: 1
     解释: 2 = 1 + 1, 1 × 1 = 1。

     示例 2:

     输入: 10
     输出: 36
     解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。

*/
    public int maxDivide(int n,int[] max){
        if (n == 2){
            return 2;
        }else if (n == 1){
            return 1;
        }else {
            int one = 0;
            int two = 0;
            int tempMax = n;
            for (int i = 1; i < n/2+1; i++) {
                if (max[i] != 0) one = max[i];
                else one = maxDivide(i,max);
                if (max[n-i] != 0) two = max[n-i];
                else two = maxDivide(n-i,max);
                tempMax = Math.max(tempMax,two*one);
            }
            max[n] = tempMax;
            return tempMax;
        }

    }
    public int integerBreak(int n) {

        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] max = new int[n+1];
        max[2] = 2;
        max[1] = 1;
        int maxThis = 0;
        return maxDivide(n,max);
    }

    public static void main(String[] args) {
        Leetcode343 leetcode343 = new Leetcode343();
        System.out.println(leetcode343.integerBreak(4));
    }
}
