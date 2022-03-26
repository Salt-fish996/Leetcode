package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode682 {
    public int calPoints(String[] ops) {
        List<Integer> l = new ArrayList<>();
        int grade = 0;
        for (String op : ops) {
            switch (op) {
                case "C":
                    l.remove(l.size() - 1);
                    break;
                case "D":
                    l.add(l.get(l.size() - 1) * 2);
                    break;
                case "+":
                    l.add(l.get(l.size() - 1) + l.get(l.size() - 2));
                    break;
                default:
                    l.add(Integer.parseInt(op));
            }
        }
        for (int i = 0; i < l.size(); i++) {
            grade += l.get(i);
        }
        return grade;
    }

    public static void main(String[] args) {
        Leetcode682 l = new Leetcode682();
        System.out.println(l.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
