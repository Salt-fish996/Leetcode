package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author hyy
 * @date 2019/12/2 11:08
 */
//通过，这里使用了带有括号的计算器，可以对这道题专门优化为只计算+-*，这样应该会减少很多时间
public class Leetcode282 {
    private void calTwo(Stack<Double> opeDigital, Stack<Character> opeFlag){
        //取出上一个运算符，如果运算符是/*那么进行运算,如果不是不进行运算
        if (opeFlag.size()>0 &&(opeFlag.peek() == '/' || opeFlag.peek() == '*')){
            double temp = opeDigital.pop();
            double digital = opeDigital.pop();
            char c = opeFlag.pop();
            if (c == '*'){//如果是乘法
                opeDigital.add(temp*digital);
            }else {//如果是除法
                if (temp == 0){
                    System.out.println("分母不能为0");
                    return;
                }
                opeDigital.add(digital/temp);

            }
        }
    }
    private void calSubString(Stack<Double> opeDigital, Stack<Character> opeFlag){//计算到一个左括号或者符号栈为空
        Stack<Double> tempDigital = new Stack<>();//用于存储数字
        Stack<Character> tempFlag = new Stack<>();//用于存储符号
        while (opeFlag.size() != 0 && opeFlag.peek() != '(' && opeFlag.peek() !='（'){//将其转化为正序计算
            tempDigital.add(opeDigital.pop());
            tempFlag.add(opeFlag.pop());
        }
        double sum = opeDigital.pop();//用于统计结果
        while (tempDigital.size()>0 && tempFlag.size() > 0){
            double temp = tempDigital.pop();
            char c = tempFlag.pop();
            if (c == '+'){
                sum = sum + temp;
            }else {
                sum = sum - temp;
            }
        }
        opeDigital.add(sum);
        if (opeFlag.size()>1 && (opeFlag.peek() != '(' || opeFlag.peek() !='（')){
            opeFlag.pop();//取出左括号
        }
    }
    public double calculate(String s){
        Stack<Character> opeFlag  = new Stack<>();//操作符号栈
        Stack<Double> opeDigital = new Stack<>();//操作数栈
        int leftBlackCount = 0;//统计左括号数目
        for (int i = 0; i < s.length(); i++) {//空格不处理
            if (s.charAt(i) != ' '){
                if (s.charAt(i) >='0' && s.charAt(i) <= '9'){//如果是数字
                    double sum = 0;
                    while (i<s.length() && s.charAt(i) >='0' && s.charAt(i) <= '9'){//计算数字
                        sum = sum * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    i--;
                    opeDigital.add(sum);
                    calTwo(opeDigital,opeFlag);
                }else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){//如果是运算符，那么将其放入栈中
                    opeFlag.add(s.charAt(i));
                }else if (s.charAt(i) == '(' || s.charAt(i) == '（'){//如果是左括号
                    opeFlag.add(s.charAt(i));
                    leftBlackCount++;
                }else if (s.charAt(i) == ')' || s.charAt(i) == '）'){//最复杂的情况下
                    leftBlackCount--;
                    calSubString(opeDigital,opeFlag);
                    calTwo(opeDigital,opeFlag);
                }else {//如果是非法字符，那么程序提示错误
                    System.out.println("非法字符，请检查！");
                    return Integer.MIN_VALUE;
                }
            }
        }
        calSubString(opeDigital,opeFlag);
        return opeDigital.pop();
    }
    //深度遍历
    /**
     * @param index 当前加符号的位置
     * @param list 存储结果
     * @param flag 主要用来对一些比如002,002,01这样开头为0的数字进行处理，即只允许0或者以不是0开头的数*/
    void dfs(String num,int target,String string,int index,List<String> list,boolean flag){
        if (index > num.length() - 1){
           if (calculate(string) == target && (string.contains("+") || string.contains("-") || string.contains("*"))){
               list.add(string);
           }
           return;
        }

        char temp = num.charAt(index);
        if (flag)
            dfs(num,target,string + ""+temp,index + 1,list,flag);


        if (temp != '0'){
            flag = true;
        }else {
            flag = false;
        }
        dfs(num,target,string + "+"+temp,index + 1,list, flag);
        dfs(num,target,string + "-"+temp,index + 1,list, flag);
        dfs(num,target,string + "*"+temp,index + 1,list, flag);

    }
    public List<String> addOperators(String num, int target) {

        List<String> list = new ArrayList<>();
        if (num.length() == 0){
            return list;
        }
        try {
            if (Integer.parseInt(num) == target){
                list.add(num);
            }
        }catch (Exception ignored){

        }

        boolean f = num.charAt(0) != '0';
        dfs(num,target,num.charAt(0) + "",1,list,f);
        return list;
    }

    public static void main(String[] args) {
        Leetcode282 leetcode282 = new Leetcode282();
        List<String> list = leetcode282.addOperators("105",5);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
