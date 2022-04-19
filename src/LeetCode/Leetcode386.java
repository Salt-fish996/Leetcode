package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l = new ArrayList<>();
        cal(n,0,l);
        return l;
    }

    public void cal(int n, int now, List<Integer> res) {
        for (int i = 0; i <= 9; i++) {
            int t = now*10+i;
            if (t == 0) {
                continue;
            }
            if (t <= n) {
                res.add(t);
                cal(n,t,res);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode386 l = new Leetcode386();
        System.out.println(l.lexicalOrder(100));
    }
}
