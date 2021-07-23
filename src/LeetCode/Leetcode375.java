package LeetCode;

public class Leetcode375 {
    /*参考答案*/
    public int calculate(int low, int high) {
        if (low >= high)
            return 0;
        int minres = Integer.MAX_VALUE;
        for (int i = (low + high) / 2; i <= high; i++) {
            int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));
            minres = Math.min(res, minres);
        }
        return minres;
    }
    public int getMoneyAmount(int n) {
        return calculate(1, n);
    }


    public static void main(String[] args) {
        Leetcode375 leetcode375 = new Leetcode375();
        System.out.println(leetcode375.getMoneyAmount(11));
    }
}
