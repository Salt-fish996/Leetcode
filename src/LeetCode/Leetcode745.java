package src.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode745 {
    class WordFilter {

        Map<String,Integer> map;
        public WordFilter(String[] words) {
            map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = 1; j <= words[i].length(); j++) {
                    for (int k = words[i].length(); k >=0 ; k--) {
                        map.put(words[i].substring(0,j)+":"+words[i].substring(k),i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return this.map.getOrDefault(pref+":"+suff,-1);
        }
    }
    public static void main(String[] args) {
        Leetcode745.WordFilter l = new Leetcode745().new WordFilter(new String[]{"abc"});
//        Leetcode745.WordFilter l = new Leetcode745().new WordFilter(new String[]{"apple","ae"});
        System.out.println(l.f("a","e"));
    }
}
