package src.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode981 {
    class TimeMap {
        Map<String, TreeMap<Integer,String>> map;
        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer,String> map = this.map.getOrDefault(key,new TreeMap<>());
            map.put(timestamp,value);
            this.map.put(key,map);
        }

        public String get(String key, int timestamp) {
            if (this.map.containsKey(key)) {
                TreeMap<Integer,String> m = this.map.get(key);
                Integer k = m.lowerKey(timestamp+1);
                if (k == null) {
                    return "";
                }
                return m.get(k);
            }
            return "";
        }
    }
}
