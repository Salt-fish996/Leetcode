package LeetCode;

import java.util.TreeMap;
/*算法时间复杂度过高，未通过*/
public class Leetcode767 {
    public String sortDiffString(String s,String result,TreeMap<Character,Integer> treeMap){
        if (s.length() == 1){
            for (Character c:treeMap.keySet()
                 ) {
                if (treeMap.get(c) != 0){
                    if (c != result.charAt(result.length()-1)) return result +c;
                }
            }
        }else {
            int count = 0;
            int zhi = 0;
            for (int v:treeMap.values()
                 ) {
                if (v != 0) {
                    count++;
                    zhi = v;
                }
            }
            if (count == 1 && zhi >1) return "";
            for (Character c:treeMap.keySet()
                 ) {
                if (result.length() == 0||(c!=result.charAt(result.length() -1)&&treeMap.get(c) >=1))
                {
                    treeMap.put(c,treeMap.get(c)-1);
                    String re =sortDiffString(s.substring(0,s.length()-1),result + c,treeMap);
                    treeMap.put(c,treeMap.get(c) +1);
                    if (re.length() >=1) return re;
                }
            }
        }
        return "";
    }
    public String sortDiffString(String s,String result,char[] chars,int[] sum){
        if (s.length() == 1){
            for (int i = 0; i < sum.length; i++) {
                if (sum[i] != 0){
                    if (chars[i] != result.charAt(result.length() -1))
                        return result + chars[i];
                    else return "";
                }
            }
        }else {
            int coun = 0;
            int sit = -1;
            for (int i = 0; i < chars.length; i++) {
                if (sum[i] != 0){
                    coun++;
                    sit = i;
                }
            }
            if (coun == 1 && sit != -1 &&sum[sit] >1) return "";
            for (int i = 0; i < chars.length; i++) {
                String temp = "";
                if (result.length() == 0 ||(result.charAt(result.length() - 1) != chars[i] && sum[i] !=0)){
                    sum[i] --;
                    temp = sortDiffString(s.substring(0,s.length()-1),result + chars[i],chars,sum);
                    sum[i] ++;
                }
                if (temp.length()>0) return temp;
            }
        }
        return "";
    }
    public String reorganizeString(String S) {

        if (S.length() == 0) return "";
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < S.length(); i++) {
//            set.add(S.charAt(i));
//        }
//        char[] chars = new char[set.size()];
//        int[] sum = new int[set.size()];
//        int count = set.size();
//        int i = 0;
//        for (char c:set
//             ) {
//            chars[i++] = c;
//        }
//
//        for (int j = 0; j < count; j++) {
//            for (int k = 0; k < S.length(); k++) {
//                if (S.charAt(k) == chars[j]){
//                    sum[j]++;
//                }
//            }
//        }
//
//        String s = sortDiffString(S,"",chars,sum);
//
        //treemap方式
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < S.length(); i++) {
            treeMap.put(S.charAt(i),0);
        }
        for (int i = 0; i < S.length(); i++) {
            treeMap.put(S.charAt(i),treeMap.get(S.charAt(i)) + 1);
        }
        String s = sortDiffString(S,"",treeMap);
        return s;
    }

    public static void main(String[] args) {
        Leetcode767 leetcode767 = new Leetcode767();
        Long start = System.currentTimeMillis();
        System.out.println(leetcode767.reorganizeString("kkkkzrkatkwpkkkktrq"));
        System.out.println(System.currentTimeMillis() - start);
    }
}