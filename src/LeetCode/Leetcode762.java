package src.LeetCode;

public class Leetcode762 {
    public int countPrimeSetBits(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            char[] bin = Integer.toBinaryString(i).toCharArray();
            int count = 0;
            for (int j = 0; j < bin.length; j++) {
                if (bin[j] == '1'){
                    count++;
                }
            }
            if (check(count)) {
                sum++;
            }
        }
        return sum;
    }
    // 校验是不是质数
    public boolean check(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return i > 1;
    }

    public static void main(String[] args) {
        Leetcode762 l = new Leetcode762();
        System.out.println(l.countPrimeSetBits(10,15));
    }
}
