package LeetCode;

import java.util.*;

//未通过
public class Leetcode964 {
    static  char[] operator = new char[]{'+','-','*','/'};
    static HashSet<String> hashSet = new HashSet<String>(Arrays.asList(new String[]{"+", "-", "*", "/"}));
    //计算只含有+-*/的式子
    public int calculate(String s){
        String[] strings = s.split(" ");
        //存储操作符
        Stack<String> operator = new Stack<>();
        //存储操作数
        Stack<Integer> digital = new Stack<>();
        digital.push(Integer.parseInt(strings[0]));
        for (int i = 1; i < strings.length; i++) {
            //如果是操作符
            if (hashSet.contains(strings[i])){
                //放入
                operator.push(strings[i]+"");
            }else {
                //操作数
                String temp = operator.peek();
                if (temp.equals("*")){
                    int a = digital.pop();
                    operator.pop();
                    digital.push(a*Integer.parseInt(strings[i]));
                }else if (temp.equals("/")){
                    int a = digital.pop();
                    operator.pop();
                    digital.push(a/Integer.parseInt(strings[i]));
                }else {
                    digital.push(Integer.parseInt(strings[i]));
                }
            }

        }

        Stack<Integer> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        for (int a:digital
        ) {
            s1.push(a);
        }

        for (String a:operator
        ) {
            s2.push(a);
        }
        while (!s2.isEmpty()){
            String t1 = s2.pop();
            int a = s1.pop();
            int b = s1.pop();
            if (t1.equals("+")){
                s1.push(a+b);
            }else {
                s1.push(a-b);
            }
        }

        return s1.pop();
    }
    public int leastOpsExpressTarget(int x, int target) {

        //使用广度遍历
        //记录表达式
        Queue<String> strings = new LinkedList<>();
        //记录运算符号数目
        Queue<Integer> operators = new LinkedList<>();

        //初始化
        strings.add("" + x);
        operators.add(0);

        while (! strings.isEmpty()){
            String temp = strings.poll();
            int operatorCount = operators.poll();
            int now = (int) calculate(temp);
            if (now == target){
                System.out.println(temp);
                return operatorCount;
            }
            for (int i = 0; i < 4; i++) {
                if (operator[i] == '+' || operator[i] == '-'){
                    strings.add(now+" " + operator[i]+" " + x);
                    operators.add(operatorCount + 1);
                }else {
                    strings.add(temp +" "+ operator[i]+" " + x);
                    operators.add(operatorCount + 1);
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode964 leetcode964 = new Leetcode964();
        System.out.println(leetcode964.leastOpsExpressTarget(3,65));
    }
}
