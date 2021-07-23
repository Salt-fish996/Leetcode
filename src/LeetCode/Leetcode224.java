package LeetCode;

import java.util.Stack;

public class Leetcode224 {
    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     *
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     *
     * 示例 1:
     *
     * 输入: "1 + 1"
     * 输出: 2
     **/
    public int calculate(String s) {

        s = s.replace(" ","");
        Stack<Character> op = new Stack<>();
        Stack<Integer> digital = new Stack<>();
        int leftBrick = 0;//用于统计左括号数目
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){//如果遇到左括号
                op.add(s.charAt(i));
                leftBrick++;
            }else if (s.charAt(i) == ')'){
                while (op.peek()!='('){
                    int first = digital.pop();
                    int second = digital.pop();
                    char c = op.pop();
                    if (c == '+'){
                        digital.push(first+second);
                    }else if (c == '-'){
                        digital.push(second - first);
                    }
                }
                op.pop();//取出左括号
                leftBrick--;
                if (op.size()!=0&&op.peek() != '(') {
                    char c = op.pop();
                    int first = digital.pop();
                    int item = digital.pop();
                    if (c == '+'){
                        digital.push(first+item);
                    }else if (c == '-'){
                        digital.push(item - first);
                    }
                }
                if (leftBrick == 0){
                    while (op.size()!=0){
                        char c = op.pop();
                        int first = digital.pop();
                        int item = digital.pop();

                        if (c == '+'){
                            digital.push(first+item);
                        }else if (c == '-'){
                            digital.push( item-first);
                        }
                    }
                }
            }else if (s.charAt(i) == '-'||s.charAt(i) == '+'){
                    op.add(s.charAt(i));
            }else {//如果本次是数字
                Integer item = Integer.valueOf("" + s.charAt(i));
                while (i+1<s.length() && s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                    item = item * 10 + s.charAt(++i) - '0';
                }

                if (leftBrick == 0){
                    if (digital.size() == 0) digital.push(item);
                    else {
                        int first = digital.pop();
                        char c = op.pop();
                        if (c == '+'){
                            digital.push(first+item);
                        }else if (c == '-'){
                            digital.push(first - item);
                        }
                    }

                }else {
                    if (op.peek() == '(') digital.push(item);
                    else {
                        char c = op.pop();
                        int first = digital.pop();
                        if (c == '+'){
                            digital.push(first+item);
                        }else if (c == '-'){
                            digital.push(first - item);
                        }
                    }
                }
            }
        }

        return digital.pop();
    }


    public static void main(String[] args) {
        Leetcode224 leetcode224 = new Leetcode224();
        String s = "(1+(4+5+2)-3)+(6+8)";
        String s1 = "2-4-(8+2-6+(8+4-(1)+8-10))";
        System.out.println(leetcode224.calculate(s));
    }
}
