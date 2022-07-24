package src.LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {

        Stack<Integer> opDitagil = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (int i = 0; i < tokens.length; i++) {
            if (set.contains(tokens[i])){
                int first = opDitagil.pop();
                int second = opDitagil.pop();
                int result = 0;
                switch (tokens[i]){
                    case "*" :result = first * second;break;
                    case "/" :result = second / first;break;
                    case "+" :result = second + first;break;
                    case "-" :result = second - first;break;
                }
                opDitagil.push(result);
            }else {
                opDitagil.push(Integer.valueOf(tokens[i]));
            }
        }
        return opDitagil.pop();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"2","1","+","3","*"};
        Leetcode150 leetcode150 = new Leetcode150();
        System.out.println(leetcode150.evalRPN(strings));
    }
}
