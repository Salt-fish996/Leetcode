import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Calculate {
    /*计算器实现，
    计算器运算顺序为：（）/*+-，采用双栈的方式来进行实现
    栈opeFlag用于存储运算符号
    栈opeDigital用于存储运算数
    用leftBlackCount来统计当前操作符栈中的左括号数目，如果遇到了右括号，那么将操作符合操作数中的符号进行操作，直到运算到一个左括号结束，
    当检测到左括号数为0了，那么就将操作数和操作符取出进行计算
    在不考虑左括号的情况下，如果当前遇到的操作符号是/*，那么检测上一个运算符，如果上一个运算符是+-，那么取下一个数，如3+4*5，如果检测到了*，由于+的
    运算优先级小于*，那么就要先计算4*5，然后将20放入到操作数中去
    如果出现如3+5*10+（5+3*2+（10*9+5））这种情况，运算顺序是，先计算括号里面的数，然后进行乘法除法运算，最后进行加减运算
    */
    private void calTwo(Stack<Double> opeDigital,Stack<Character> opeFlag){
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

    public static void main(String[] args) throws IOException {
        Calculate calculate = new Calculate();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(calculate.calculate(s));
//        File file = new File("C:\\Users\\Administrator\\Desktop\\24point.txt");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//        while (true){
//            String s1 = reader.readLine().replace(".0","");
//            if (s1 == null)break;
//            System.out.println(s1+"="+(int)(calculate.calculate(s1)+0.1));
//        }
    }
}
