package src.LeetCode;

import java.util.Arrays;

public class Leetcode891 {
    //Cn0+Cn1+...+Cnn = 2^n-1
    //求余会出错
    static long mod = (long)Math.pow(10,9) + 7;
    public int sumSubseqWidths(int[] A) {

        Arrays.sort(A);
        int count = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                count += (A[j] - A[i])*Math.pow(2,j-i-1)%mod;
            }
        }
        return count;
    }

    //官方解答
    public int sumSubseqWidths2(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; ++i)
            pow2[i] = pow2[i-1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < N; ++i)
            ans = (ans + (pow2[i] - pow2[N-1-i]) * A[i]) % MOD;

        return (int) ans;
    }


    public static void main(String[] args) {
        Leetcode891 leetcode891 = new Leetcode891();
        int[] a = new int[]{2,1,3};
        System.out.println(leetcode891.sumSubseqWidths(a));
    }
}
