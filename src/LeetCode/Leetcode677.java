package src.LeetCode;

import java.util.HashMap;

//键值映射，通过
public class Leetcode677 {
public class MapSum{
    HashMap<String,Integer> hashMap = null;
        /** Initialize your data structure here. */
        public MapSum() {
            hashMap = new HashMap<>();
        }

        public void insert(String key, int val) {

            hashMap.put(key,val);
        }

        public int sum(String prefix) {

            int count = 0;
            for (String s:hashMap.keySet()
                 ) {
                if (s.length()>prefix.length() && prefix.equals(s.substring(0,prefix.length()))){
                    count += hashMap.get(s);
                }
            }
            return count;
        }
    }
}
