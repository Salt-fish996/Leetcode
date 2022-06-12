package src.LeetCode;

import java.util.*;

public class Leetcode890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (check(words[i],pattern)) {
                res.add(words[i]);
            }
        }
        return res;
    }

    public boolean check(String word,String pattern) {
        HashMap<Character,Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
               if (pattern.charAt(i) == map.get(word.charAt(i))) {
                   continue;
               }
               return false;
            }
            if (set.contains(pattern.charAt(i))) {
                return false;
            }
            set.add(pattern.charAt(i));
            map.put(word.charAt(i),pattern.charAt(i));
        }
        return true;
    }

}
