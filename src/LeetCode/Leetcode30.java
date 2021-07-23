package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//串联所有单词的子串，通过
public class Leetcode30 {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return list;
        //首先将words中按照字符顺序排序
        Arrays.sort(words);
        int n = s.length();
        int m = words[0].length();//每个单词的长度
        int size = words.length;//单词的数目
        for (int i = 0; i <= n - size * m; i++) {
            int count = 0;
            int j = i;
            String[] strings = new String[size];
            //开始切割
            while (count < size){
                strings[count++] = s.substring(j,j + m);
                j = j + m;
            }
            boolean flag = false;
            Arrays.sort(strings);
            System.out.println(Arrays.toString(strings));
            //开始比较
            for (int k = 0; k < size; k++) {
                if (!words[k].equals(strings[k])){
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        Leetcode30 leetcode30 = new Leetcode30();
        String s = "wordgoodgoodgoodbestword";
        String[]   words = new String[]{"word","good","best","good"};
        System.out.println(leetcode30.findSubstring(s,words));
    }
}
