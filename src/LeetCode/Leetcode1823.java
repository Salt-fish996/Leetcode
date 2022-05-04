package LeetCode;

public class Leetcode1823 {
    public int findTheWinner(int n, int k) {
        int count = n;
        int begin = 0;
        int[] arr = new int[n];
        while (count > 1) {
            int c = 0;
            int before = begin;
            while (c < k) {
                if (arr[begin] == 0) {
                    c++;
                }
                before = begin;
                if (begin == n-1) {
                    begin = 0;
                }else {
                    begin += 1;
                }
            }
            arr[before] = 1;
            count--;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                return i+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode1823 l = new Leetcode1823();
        System.out.println(l.findTheWinner(6,5));
    }
}
