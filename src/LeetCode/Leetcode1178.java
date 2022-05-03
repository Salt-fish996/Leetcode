package src.LeetCode;

import java.util.*;

public class Leetcode1178 {
    // 超时，未通过
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // 为单词构造一个map，记录单词中包含的字母是什么
        Map<String, Set<Character>> wordVo = new HashMap<>();
        // 记录每一个单词的前缀
        Map<Character,Set<String>> prefix = new HashMap<>();
        for (int i = 0; i < words.length; i++) {

            Set<Character> set = new HashSet<>();
            char[] arr = words[i].toCharArray();

            for (char c : arr) {
                set.add(c);
                if (set.size() > 7) {
                    break;
                }
            }
            for (char c:set) {
                Set<String> sp = prefix.getOrDefault(c,new HashSet<>());
                sp.add(words[i]);
                prefix.put(c,sp);
            }
            wordVo.put(words[i],set);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < puzzles.length; i++) {
            int count = 0;
            char[] pArr = puzzles[i].toCharArray();
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < pArr.length; j++) {
                set.add(pArr[j]);
            }
            // 找到含有第一个单词的
            Set<String> hasOneVo = prefix.get(pArr[0]);
            if (hasOneVo == null ){
                res.add(0);
                continue;
            }
            for (String word:hasOneVo
                 ) {
                // 获取所有字符
                boolean hasAll = true;
                Set<Character> wordChar = wordVo.get(word);
                for (char c:wordChar
                     ) {
                    if (!set.contains(c)) {
                        hasAll = false;
                        break;
                    }
                }
                count += hasAll?1:0;
            }
            res.add(count);

        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1178 l = new Leetcode1178();
        System.out.println(l.findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"},new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}));
    }
}
