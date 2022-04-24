package src.LeetCode;

import java.util.*;

public class Leetcode1363 {
    Map<String,String> m = new HashMap<>();
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        if (digits.length >0 && digits[digits.length-1] == 0) {
            return "0";
        }
        String res =  dpf(digits,digits.length-1,0);
        if (res.length() > 0 && res.replace("0","").length() == 0) {
            return "0";
        }
        return res;
    }

    String dpf(int[] digits, int now, int leave) {
        String key = now+" "+leave;
        if (m.containsKey(key)) {
            return m.get(key);
        }
        if (now == -1) {
            if (leave == 0) {
                return "";
            }
            return "-";
        }
        String s1 = dpf(digits,now-1,(leave*10+digits[now]) % 3);
        if (Objects.equals(s1, "-")) {
            s1 = "-";
        } else {
            s1 = digits[now]+s1;
        }
        String s2 = dpf(digits,now-1,leave);
        String max = (s1.length() >= s2.length() && !s1.equals("-")) || s2.equals("-") ? s1:s2;
        m.put(key,max);
        return max;
    }

    public static void main(String[] args) {
        Leetcode1363 l = new Leetcode1363();
        System.out.println(l.largestMultipleOfThree(new int[]{8,1,9}));
//        System.out.println(l.largestMultipleOfThree(new int[]{6,0,8,2,6,3,5,8,6,3,0,9,8,0,8,5,4,5,1,6,9,3,0,4,7,4,3,7,8,2,6,8,3,3,7,9,2,6,6,9,9,7,8,3,5,9,8,1,1,2,9,8,8,3,8,1,9,5,3,1,7,2,0,0,4,5,0,1,3,5,8,8,4,4,0,7,5,2,4,3,6,7,5,8,6,6,8,3,4,1,3,9,0,7,3,1,1,9,3,7,2,6,7,6,4,5,6,1,5,0,6,0,6,0,7,4,6,4,2,6,3,1,4,6,8,6,0,2,1,8,5,2,9,7,9,6,3,2,2,9,3,7,1,9,7,3,3,7,6,4,6,1,8,8,5,6,6,8,7,1,5,0,7,2,2,9,4,0,7,5,3,5,8,1,1,5,8,8,2,4,1,6,8,0,5,5,7,0,2,8,9,9,9,3,8,3,2,2,9,3,1,1,7,3,2,3,9,6,6,1,3,7,4,7,6,7,5,4,5,0,7,7,4,9,5,8,5,6,1,6,1,6,9,9,3,4,4,8,6,7,1,8,2,7,7,4,3,9,7,9,4,8,3,6,2,0,2,1,3,8,7,7,6,4,8,3,6,9,8,1,3,3,6,3,6,8,5,3,4,8,3,3,5,3,8,7,0,1,9,1,2,1,2,9,9,9,2,1,5,6,4,4,9,3,1,0,3,0,0,5,8,5,5,4,6,6,5,4,7,4,1,4,7,0,7,1,6,4,5,0,8,2,9,3,1,7,7,9,9,2,5,6,6,8,2,9,5,8,4,5,6,3,5,2,7,7,2,1,3,2,2,7,9,8,7,7,4,4,5,1,6,1,8,9,3,0,4,6,3,5,4,1,0,8,9,6,9,8,0,2,9,1,6,7,1,0,8,7,5,4,0,5,6,9,5,7,1,5,2,1,5,9,2,5,6,9,8,9,3,7,3,3,6,5,9,3,8,2,9,4,6,9,5,7,8,0,6,3,4,5,8,6,4,1,8,8,9,3,2,0,4,2,1,9,6,7,7,2,9,2,8,2,6,2,1,3,8,5,1,6,2,0,7,2,8,1,0,2,2,5,9,5,8,2,5,1,2,3,9,4,8,9,8,9,3,4,3,4,4,3}));
    }

}
