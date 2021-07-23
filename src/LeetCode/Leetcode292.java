package LeetCode;

public class Leetcode292 {
    public boolean canWinNim(int n) {
        int m = n%4;
        if (m>0 && m<=3) return true;
        else return false;
    }
}
