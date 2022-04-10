package src.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] s = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String ss = words[i];
            String f = "";
            for (int j = 0; j < ss.length(); j++) {
                f += s[ss.charAt(j) - 'a'];
            }
            if (!set.contains(f)) {
                set.add(f);
            }
        }
        return set.size();
    }
}
