package src.LeetCode;
import java.util.*;
public class Leetcode728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> l = new ArrayList<>();
        for (int i = left; i <= right; i++) {
           if (check(i)) {
               l.add(i);
           }
        }
        return l;
    }
    public boolean check(int num) {
        int n = num;
       while (n > 0) {
           if (n%10 == 0 || num %(n%10) != 0) {
              return false;
           }
           n = n/10;
       }
       return true;
    }
}
