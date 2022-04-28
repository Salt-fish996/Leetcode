package src.LeetCode;

import java.util.Stack;

public class Leetcode856 {
    public int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (stack.empty()) {
                stack.push(arr[i]);
                sums.push(0);
                continue;
            }
            if (arr[i] == '(') {
                stack.push(arr[i]);
                sums.add(0);
                continue;
            }
            stack.pop();
            int sum = sums.pop();

            while (sums.size() >= stack.size()&&sums.size() != 0) {
                sum += sums.pop();
            }
            sum = sum>0?2*sum:1;
            if (stack.size() == 0) {
                res += sum;
                sum = 0;
            }
            sums.add(sum);
        }
        while (sums.isEmpty()) {
            res += sums.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode856 l = new Leetcode856();
        System.out.println(l.scoreOfParentheses("()(())"));
    }

}
