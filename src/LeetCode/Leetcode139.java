package src.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode139 {
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo){
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }


    public boolean wordBreak(String s, List<String> wordDict) {

        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);

//        if (s.length() == 0) return true;
//        for (int i = s.length(); i >= 0; i--) {
//            if (wordDict.contains(s.substring(0,i))){
//                if (i == s.length()) return true;
//                if (wordBreak(s.substring(i),wordDict)) return true;
//            }
//        }
//        return false;
    }

    public static void main(String[] args) {
        Leetcode139 leetcode139 = new Leetcode139();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] strings = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i]);
        }
        System.out.println(leetcode139.wordBreak(s,list));
    }
}
