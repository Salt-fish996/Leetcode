package LeetCode;

import java.util.Stack;

/**
 * @author hyy
 * @date 2019/8/4 21:49
 */
public class Leetcode20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public boolean isValid(String s) {
        char[] quoto = new char[]{'(',')'};
        char[] mid = new char[]{'{','}'};
        char[] big = new char[]{'[',']'};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == quoto[0] || temp == mid[0] || temp == big[0]) stack.push(temp);
            else if (stack.isEmpty()) return false;
           else
            if (temp == quoto[1] && stack.peek() == quoto[0]) stack.pop();
            else if (temp == mid[1] && stack.peek() == mid[0]) stack.pop();
            else if (temp == big[1] && stack.peek() == big[0]) stack.pop();
            else  return false;

        }
        if (stack.isEmpty()) return true;
        else return false;

    }

    public static void main(String[] args) {
        String s = "{((()))}";
        System.out.println((new Leetcode20()).isValid("(])"));
    }
}
