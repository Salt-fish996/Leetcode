package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] ds = new String[dictionary.size()];
        for (int i = 0; i < dictionary.size(); i++) {
            ds[i] = dictionary.get(i);
        }
        Arrays.sort(ds, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return o1.length()-o2.length();
            }
        });

        StringBuilder res = new StringBuilder();
        String[] ss = sentence.split(" ");
        boolean hasPrefix = false;
        for (int i = 0; i < ss.length; i++) {
            hasPrefix = false;
            for (int j = 0; j < ds.length; j++) {
                if (ss[i].startsWith(ds[j])) {
                    hasPrefix = true;
                    res.append(ds[j]);
                    break;
                }
            }
            if (!hasPrefix) {
                res.append(ss[i]);
            }
            res.append(" ");
        }
        return res.toString().trim();
    }
}
