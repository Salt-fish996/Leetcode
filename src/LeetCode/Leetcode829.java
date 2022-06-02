package src.LeetCode;

public class Leetcode829 {
    public int consecutiveNumbersSum(int n) {
        int res = 1;
        for (int i = 2; i < n; i++) {
            int i1 = 2 * n + i - i * i;
            if (i1 <= 0) {
                break;
            }
            // i 表示有多少个数字
            // (x+x+i-1)*i/2=n->(2x-1+i)=2n/i->2x=2n/i+1-i->x=n/i+1/2
            if (i1 % (2*i) == 0){
                int x = i1 / (2*i);
//                System.out.println(x);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode829 l = new Leetcode829();
        System.out.println(l.consecutiveNumbersSum(150000000));
    }
}
