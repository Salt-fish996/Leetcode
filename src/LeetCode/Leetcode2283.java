package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2283 {
    public boolean digitCount(String num) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            int c = num.charAt(i)-'0';
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < num.length(); i++) {
            int c = 0;
            if (map.containsKey(i)) {
                c = map.get(i);
            }
            if (c != num.charAt(i) - '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode2283 l = new Leetcode2283();
        System.out.println(l.digitCount("1210"));
    }
}
