package src.LeetCode;


import java.util.HashMap;
import java.util.HashSet;

//最小滑动子串：滑动窗口实现,通过
public class Leetcode76 {
    public String minWindow(String s, String t) {


        int left = 0;//左指针
        int right = 0;//右指针
        HashMap<Character,Integer> hashMap = new HashMap<>();//用于存储当前窗口中各个字母的数量
        HashSet<Character> hashSet = new HashSet<>();//用于存储当前窗口中没有的字母
        HashMap<Character,Integer> need = new HashMap<>();//每个字符需要的数量

        int n = s.length();
        int m = t.length();
        //初始化
        for (int i = 0; i < m; i++) {
            hashMap.put(t.charAt(i),0);
            hashSet.add(t.charAt(i));
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        int max = Integer.MAX_VALUE;
        String result = "";
        while (right < n){
           // System.out.println("right="+right);
            //System.out.println("set="+hashSet.toString());
            if (t.contains(s.charAt(right) + "")){//如果当前字符是在t中的
                //将当前字母加入
                hashMap.put(s.charAt(right),hashMap.get(s.charAt(right)) + 1);
                //如果缺少的字符中有当前字符，那么将其从hashSet中移去
                if (hashMap.get(s.charAt(right)) >= need.get(s.charAt(right)))
                hashSet.remove(s.charAt(right));
            }
            //如果还有字母没有包括，那么右指针右移
            right++;


            //如果已经包含了所有子串
            if (hashSet.isEmpty()){
                if (right - left < max){
                    result = s.substring(left,right);
                    max = right - left;
                }
                    while (true){
                        //System.out.println(left + "  " + right);
                        if (t.contains(s.charAt(left) + "")){
                            //获取当前left所指向的字母在滑动窗口中的数目
                            int count = hashMap.get(s.charAt(left));
                            //如果数目等于1，那么退出当前循环，去移动右指针
                            if (count == need.get(s.charAt(left))){
                                if (max > right - left){
                                    result = s.substring(left,right);
                                    max = right - left;
                                }
                                hashSet.add(s.charAt(left));
                                hashMap.put(s.charAt(left),count - 1);
                                left++;
                                break;
                            }else{
                                hashMap.put(s.charAt(left),hashMap.get(s.charAt(left)) - 1);
                            }
                        }
                        left ++ ;
                    }
            }}
        return result;
    }

    public static void main(String[] args) {
        Leetcode76 leetcode76 = new Leetcode76();
        String s = "A";
        String t = "A";
        System.out.println(leetcode76.minWindow(s,t));
    }
}
