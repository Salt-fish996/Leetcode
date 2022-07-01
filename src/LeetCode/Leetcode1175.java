package src.LeetCode;

public class Leetcode1175 {
    public int numPrimeArrangements(int n) {
        if (n < 3) {
            return 1;
        }
        long mod = (long) (1e9+7);
        int count = 0;
        long sum1 = 1;
        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                count++;
            }
        }

        for (int i = 1; i <= count; i++) {
            sum1 *= i;
            sum1 = sum1 % mod;
        }
        long sum2 =1;
        for (int i = 1; i <= n-count; i++) {
            sum2 *= i;
            sum2 = sum2 % mod;
        }
        return (int) ((sum1*sum2) % mod);
    }
    public boolean check(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i*i <= n ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode1175 l = new Leetcode1175();
        System.out.println(l.numPrimeArrangements(5));
    }
}
