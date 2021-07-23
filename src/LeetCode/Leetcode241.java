package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hyy
 * @date 2019/12/2 12:30
 */
//通过，96.87%
public class Leetcode241 {
    //使用数组dp[i][j]来记录从i到j的所有可能的结果
    //i==j 时候dp[i][j]=input.chatAt(i)
    //dp[i][j]=dp[i][k] input.charAt(k+1) dp[k + 2][j]
    public List<Integer> diffWaysToCompute(String input) {

        if (!input.contains("+")&&!input.contains("-")&&!input.contains("*")){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(input));
            return list;
        }
        //用来记录数字
        ArrayList<Integer> digital = new ArrayList<>();
        String newInput = "";
        for (int i = 0; i < input.length();) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                newInput += c;
                digital.add(0);
                i++;
            }else {
                int count = c - '0';
                i++;
                while (i < input.length()){
                    if ((c = input.charAt(i)) >='0' && c<='9'){
                        count = count * 10 + c - '0';
                        i++;
                    }else {
                        break;
                    }
                }
                newInput += "0";
                digital.add(count);
            }
        }
        input = newInput;
        int n = input.length();
        ArrayList<Integer>[][] dp = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new ArrayList<Integer>();
            }
        }

        //这里需要根据步长进行计算
        for (int step = 0;step < n; step += 2 )
        for (int i = 0; i < n; i += 2) {
            for (int j = i + step; j <= i + step && j < n ; j += 2) {
                if (i == j){
                    dp[i][j].add(digital.get(i));
                }else {
                    for (int k = i; k < j; k += 2) {
                        char op = input.charAt(k + 1);
                        if (op == '-'){
                            for (Integer integer:dp[i][k]
                                 ) {
                                for (Integer integer1:dp[k + 2][j]) {
                                    dp[i][j].add(integer - integer1);
                                }
                            }
                        }else if (op == '+'){
                            for (Integer integer:dp[i][k]
                            ) {
                                for (Integer integer1:dp[k + 2][j]) {
                                    dp[i][j].add(integer + integer1);
                                }
                            }
                        }else if (op == '*'){
                            for (Integer integer:dp[i][k]
                            ) {
                                for (Integer integer1:dp[k + 2][j]) {
                                    dp[i][j].add(integer * integer1);
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[0][input.length() - 1];
    }

    public static void main(String[] args) {
        Leetcode241 leetcode241 = new Leetcode241();
        System.out.println(Arrays.toString(leetcode241.diffWaysToCompute("10+5+78-48+59*1").toArray()));
    }
}
