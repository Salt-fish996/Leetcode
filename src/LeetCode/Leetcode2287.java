package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2287 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int res = 0;
        while (true) {
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                int count = map.getOrDefault(c,0);
                if (map.containsKey(c) && count > 0 ) {
                    map.put(c,count-1);
                    continue;
                }
                return res;
            }
            res++;
        }
    }
}
