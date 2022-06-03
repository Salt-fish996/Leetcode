package src.LeetCode;

public class Leetcodeoffer44 {
    public int findNthDigit1(int n) {
        if (n < 10) {
            return n;
        }
        // 一位数的10
        // 二位数的100
        // 3位数的1000
        int count = 1;
        int sum = 10;
        while (sum < n) {
            count++;
            sum += Math.pow(10,count);
        }
        if (sum == n) {
            return 9;
        }
        sum -= Math.pow(10,count);
        int t = (int) ((n+1-sum) / count+ Math.pow(10,count-1)); // 一共用多少个整数
        int shenyu = (n+1-sum) % count; // 这就是第几位数
        return Integer.parseInt(""+Integer.toString(t).charAt(shenyu-1));
    }

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        Leetcodeoffer44 l = new Leetcodeoffer44();
        System.out.println(l.findNthDigit(400));
    }
}
