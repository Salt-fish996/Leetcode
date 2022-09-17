package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,Integer> first = new HashMap<>();
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first.containsKey(c)) {
                res = Math.max(res,i-first.get(c)-1);
            } else {
                first.put(c,i);
            }
        }
        return res;
    }
}
