package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

//实现一个魔法词典，通过
public class Leetcode676 {
    class MagicDictionary {

        HashMap<String, HashSet<String>> hashSetHashMap = null;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            hashSetHashMap = new HashMap<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (int i = 0; i < dict.length; i++) {
                String temp = dict[i];
                HashSet<String> strings = new HashSet<>();
                for (int j = 0; j < temp.length(); j++) {
                    strings.add(temp.substring(0,j)+"*"+temp.substring(j+1,temp.length()));
                }
                hashSetHashMap.put(temp,strings);
            }

        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {

            for (String s:hashSetHashMap.keySet()
                 ) {
                for (int i = 0; i < word.length(); i++) {
                    if (hashSetHashMap.get(s).contains(word.substring(0,i) + "*" + word.substring(i+1)) && s.charAt(i) != word.charAt(i)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
