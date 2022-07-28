package src.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leetcode592 {
    public String fractionAddition(String expression) {
        List<String> l = new ArrayList<>();
        StringBuffer s = new StringBuffer();
        s.append(expression.charAt(0));
        for (int i = 1; i < expression.length(); i++) {
            char t = expression.charAt(i);
            if (t == '-' || t == '+') {
                l.add(s.toString());
                s = new StringBuffer();
            }
             s.append(t);
        }
        l.add(s.toString());
        String t = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            t = cal(t,l.get(i));
        }

        return t;
    }

    public String cal(String s1,String s2) {
        String[] ss1 = s1.split("/");
        String[] ss2 = s2.split("/");

        int s11 = Integer.parseInt(ss1[0]);
        int s12 = Integer.parseInt(ss1[1]);
        int s21 = Integer.parseInt(ss2[0]);
        int s22 = Integer.parseInt(ss2[1]);

        return calString(s11*s22+s21*s12,s12*s22);
    }

    public String calString(int s1,int s2) {
        for (int i = Math.min(Math.abs(s1),s2);i >= 2; i--) {
            if (s1 % i == 0 && s2%i == 0) {
                return s1 / i +"/"+s2/i;
            }
        }
        if (s1 == 0) {
            s2 = 1;
        }
        return s1+"/"+s2;
    }

    public static void main(String[] args) {
        Leetcode592 l = new Leetcode592();
        System.out.println(l.fractionAddition("-1/4-4/5-1/4"));
    }
}
