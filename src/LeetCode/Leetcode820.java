package src.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode820 {
    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0) {
            return 0;
        }
        List<String> l = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean needAdd = true;
            for (int j = 0; j < l.size(); j++) {
                String s = l.get(j);
                if (s.length() >= word.length() && s.endsWith(word)) {
                    needAdd = false;
                    break;
                } else if (s.length() <= word.length() && word.endsWith(s)) {
                    needAdd = false;
                    l.set(j,word);
                    count += word.length() - s.length();
                }
            }

            if (needAdd) {
                l.add(word);
                count+= word.length() + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode820 l = new Leetcode820();
        System.out.println(l.minimumLengthEncoding(new String[]{"me","time"}));
    }
}
