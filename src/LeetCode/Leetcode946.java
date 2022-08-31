package src.LeetCode;

import java.util.Stack;

public class Leetcode946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[index]) {
                index++;
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek() == popped[index]) {
                    stack.pop();
                    index++;
                } else {
                    break;
                }
            }
            stack.push(pushed[i]);
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == popped[index]) {
                stack.pop();
                index++;
            } else {
                break;
            }
        }
        return stack.size() == 0;
    }
}
