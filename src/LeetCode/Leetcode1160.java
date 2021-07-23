package LeetCode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyy
 * @date 2020/3/17 11:57
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和
 */
public class Leetcode1160 {
    public int countCharacters(String[] words, String chars) {

        int result = 0;
        //使用map记录每个单词出现的次数
        Map<Character, Integer> record = new HashMap<>();
        char[] chars1 = chars.toCharArray();
        int n = chars.length();
        for (int i = 0; i < n; i++) {
            record.put(chars1[i], record.getOrDefault(chars1[i],0) + 1);
        }

        for (int i = 0; i < words.length; i++) {
            char[] temp = words[i].toCharArray();
            Map<Character, Integer> map = new HashMap<>(record);
            boolean flag = true;
            for (int j = 0; j < temp.length; j++) {
                Integer integer = map.get(temp[j]);
                if (integer == null || integer == 0) {
                    flag = false;
                    break;
                } else {
                    map.put(temp[j], map.get(temp[j]) - 1);
                }
            }

            if (flag) {
                System.out.println(temp);
                result += temp.length;
            }

        }
        return result;
    }
}
