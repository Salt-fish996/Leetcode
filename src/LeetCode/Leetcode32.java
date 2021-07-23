package LeetCode;

import java.util.Stack;

/**
 * @author hyy
 * @date 2019/9/12 9:08
 */
public class Leetcode32 {
    /**
     * */
    public int longestValidParentheses(String s) {

        if (s.length() == 0) return 0;
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char charTemp;
            int tempcount = 0;
            while (i<s.length()&&(charTemp = s.charAt(i)) == ')' && !stack.empty()&&stack.peek() == '('){
                stack.pop();
                i++;
                tempcount++;
            }
            if (i<s.length()) stack.add(s.charAt(i));
            if (tempcount > count) count = tempcount;
        }
        return count*2;
    }

    public static void main(String[] args) {
        String s = ")()())";
        Leetcode32 leetcode32 = new Leetcode32();
        System.out.println(leetcode32.longestValidParentheses(s));
    }
}
