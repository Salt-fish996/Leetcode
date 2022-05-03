package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digs = new ArrayList<>();
        List<String> vocabularies = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            char[] arr = logs[i].split(" ")[1].toCharArray();
                if (arr[0] >= 'a' && arr[0] <= 'z') {
                    vocabularies.add(logs[i]);
                } else {
                    digs.add(logs[i]);
                }
        }

        vocabularies.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split(" ");
                String[] arr2 = o2.split(" ");
                String content1 = o1.substring(arr1[0].length()+1);
                String content2 =o2.substring(arr2[0].length()+1);
                if (content1.equals(content2)) {
                    return arr1[0].compareTo(arr2[0]);
                }
                return content1.compareTo(content2);
            }
        });
        for (int i = 0; i < vocabularies.size(); i++) {
            logs[i] = vocabularies.get(i);
        }
        for (int i = 0; i < digs.size(); i++) {
            logs[i+vocabularies.size()] = digs.get(i);
        }

        return logs;
    }

    public static void main(String[] args) {
        Leetcode937 l = new Leetcode937();
        System.out.println(Arrays.toString(l.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
    }
}
