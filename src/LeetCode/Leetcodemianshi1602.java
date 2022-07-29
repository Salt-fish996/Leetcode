package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcodemianshi1602 {
    class WordsFrequency {
        Map<String,Integer> map;
        public WordsFrequency(String[] book) {
            this.map = new HashMap<>();
            for (String s : book) {
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }

        public int get(String word) {
            return this.map.getOrDefault(word,0);
        }
    }
}
