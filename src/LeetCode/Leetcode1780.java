package src.LeetCode;

public class Leetcode1780 {
    public boolean checkPowersOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0 && (n-1)%3!=0) {
            return false;
        }
        if ((n-1)%3 ==0) {
            return checkPowersOfThree((n-1)/3);
        }
        return (checkPowersOfThree(n/3));
    }

    public static void main(String[] args) {
        Leetcode1780 l = new Leetcode1780();
        System.out.println(l.checkPowersOfThree(91));
    }
}
