package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode824 {
    public String toGoatLatin(String sentence) {
        StringBuilder res = new StringBuilder();
        String[] arr = sentence.split(" ");
        StringBuilder a = new StringBuilder();
        Set<String> set = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));
        for (int i = 0; i < arr.length; i++) {
            a.append("a");
            String s = ""+arr[i].charAt(0);
            if (set.contains(s.toLowerCase())) {
                arr[i] += "ma";
            } else {
                arr[i] = arr[i].substring(1)+s+"ma";
            }
            if (i > 0) {
                res.append(" ");
            }
            res.append(arr[i]).append(a);
        }
        return res.toString();
    }
}
