package src.LeetCode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;

public class Leetcode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map = new HashMap<>();
        String[] arr = paragraph.replace("!"," ").replace("?"," ").replace("'"," ").replace(","," ").replace(";"," ").replace("."," ").replace("  "," ").split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i].toLowerCase())) {
                continue;
            }
            int count = map.getOrDefault(arr[i].toLowerCase(),0);
            map.put(arr[i].toLowerCase(),count+1);
        }
        int max = 0;
        String res = "";
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
