package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Leetcodeoffer005 {
    public int maxProduct(String[] words) {
        // 排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (check(words[i],words[j])) {
                    max = Math.max(words[i].length() * words[j].length(),max);
                }
            }
        }
        return max;
    }

    public boolean check(String s1,String s2) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            s.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s.contains(s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcodeoffer005 l = new Leetcodeoffer005();
        System.out.println(l.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
    }
}
