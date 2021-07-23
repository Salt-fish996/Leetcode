package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2019/8/1 21:45
 */
public class Leetcode3 {
    /**
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */
    public int lengthOfLongestSubstring(String s) {
        int count = 0;

        int temp = 0;
        ArrayList<Character> set = new ArrayList();

        for (int j = 0; j < s.length(); j++) {
            if (set.isEmpty()){
                set.add(s.charAt(j));
                temp++;
            }else if (set.contains(s.charAt(j))){
                if (temp > count)
                    count = temp;
                int now = set.indexOf(s.charAt(j));
                for (int i = 0;i<=now;i++)
                {
                    set.remove(0);
                    temp--;
                }
                set.add(s.charAt(j));
                temp++;
            }else {
                set.add(s.charAt(j));
                temp++;
            }


        }
        if (temp > count)
            count = temp;

        return count;
    }

    public static void main(String[] args) {
        String s = " ";
        Leetcode3 leetcode3 = new Leetcode3();
        System.out.println(leetcode3.lengthOfLongestSubstring(s));
    }
}
