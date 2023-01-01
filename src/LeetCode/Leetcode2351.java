package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2351 {
    public char repeatedCharacter(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i),0);
            if (count == 1) {
                return s.charAt(i);
            }
            map.put(s.charAt(i),1);
        }
        return ' ';
    }
}
