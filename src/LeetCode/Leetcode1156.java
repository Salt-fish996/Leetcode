package src.LeetCode;

import java.util.*;

public class Leetcode1156 {
    public int maxRepOpt1(String text) {
        if (text.length() == 0) {
            return 0;
        }
        // 统计每个字符的起点和长度
        HashMap<Character, List<Integer>> map = new HashMap<>(); // key 为字符， value 为起点
        HashMap<Integer,Integer> l = new HashMap<>(); // key 为起点，value为长度
        HashMap<Integer,Boolean> has = new HashMap<>(); // key为起点，value为是否有相隔一个位置的店
        char now = text.charAt(0);
        int len = 1;
        int index = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        map.put(now,list);
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == now) {
                len++;
            } else {
                l.put(index,len);
                if (index+len+1 < text.length() && text.charAt(index+len+1) == now  ){
                    has.put(index,true);
                }
                len = 1;
                index = i;
                list = map.getOrDefault(text.charAt(i),new ArrayList<>());
                list.add(i);
                map.put(text.charAt(i),list);
                now = text.charAt(i);
            }
        }
        l.put(index,len);
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry :map.entrySet()
                ) {
            List<Integer> list1 = entry.getValue();
            for (int i = 0; i < list1.size(); i++) {
                index = list1.get(i);
                len = l.get(index);
                if (has.containsKey(index)) {
                    res = Math.max(len+l.get(index+1+len)+(list1.size() > 2?1:0),res);
                } else {
                    res = Math.max(len+(list1.size()>1?1:0),res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1156 l = new Leetcode1156();
        System.out.println(l.maxRepOpt1("bbaaaabbccbb"));
    }
}
