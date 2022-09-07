package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1592 {
    public String reorderSpaces(String text) {
        int count = 0;
        StringBuilder s = new StringBuilder();
        List<String> l = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                count++;
                if (!s.toString().equals("")) {
                    l.add(s.toString());
                    s = new StringBuilder();
                }
            } else {
                s.append(text.charAt(i));
            }
        }
        if (!s.toString().equals("")) {
            l.add(s.toString());
        }
        StringBuilder res = new StringBuilder();
        if (l.size() == 1) {
            res.append(l.get(0));
            for (int i = 0; i < count; i++) {
                res.append(" ");
            }
            return res.toString();
        }
        for (int i = 0; i < l.size(); i++) {
            res.append(l.get(i));
            for (int j = 0; j < (count / (l.size()-1)) && i != l.size()-1; j++) {
                res.append(" ");
            }
        }
        for (int i = 0; i < (count % (l.size()-1)); i++) {
            res.append(" ");
        }
        System.out.println(count+": "+l.size());
        return res.toString();
    }
}
