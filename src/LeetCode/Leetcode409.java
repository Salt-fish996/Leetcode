package src.LeetCode;

import java.util.HashMap;

/**
 * @author hyy
 * @date 2020/3/19 9:18
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class Leetcode409 {
//    public int maxLongth(char[] chars, int i) {
//        //从i向外扩展
//        int result = 1;
//        int left = i - 1;
//        int right = i + 1;
//        int count = 1;
//        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
//            left --;
//            right ++;
//            count += 2;
//        }
//        result = Math.max(count, result);
//        left = i - 1;
//        right = i + 1;
//        if (left >=0 &&chars[left] == chars[i]) {
//            left --;
//            count = 2;
//            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
//                left --;
//                right ++;
//                count += 2;
//            }
//
//            result = Math.max(count, result);
//        }
//        left = i - 1;
//        right = i + 1;
//        if (right < chars.length && chars[right] == chars[i]) {
//            right ++;
//            count = 2;
//            while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
//                left --;
//                right ++;
//                count += 2;
//            }
//
//            result = Math.max(count, result);
//        }
//        return result;
//    }
//    public int longestPalindrome(String s) {
//        char[] chars = s.toCharArray();
//        int result = 0;
//        for (int i = 0; i < chars.length; i++) {
//            result = Math.max(result, maxLongth(chars, i));
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Leetcode409 leetcode409 = new Leetcode409();
        System.out.println(leetcode409.longestPalindrome("aadccccdd"));
    }

    public int longestPalindrome(String s) {
        //使用HashMap统计每个字符的数目
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            hashMap.put(chars[i], hashMap.getOrDefault(chars[i], 0) + 1);
        }

        //然后遍历hashmap，如果是偶数那么直接相加
        //记录有没有奇数
        boolean flag = false;
        int result = 0;
        for (int i: hashMap.values()
             ) {
            if (i % 2 == 0) {
                result += i;
            } else {
                flag = true;
                result += i - 1;
            }
        }
        return flag?(result + 1) : (result);
    }
}
