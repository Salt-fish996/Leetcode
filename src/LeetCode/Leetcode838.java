package LeetCode;

import java.util.Arrays;

/**
 * @author hyy
 * @date 2019/11/28 12:37
 */
//推多米洛骨牌,通过
public class Leetcode838 {
    public String pushDominoes(String dominoes) {

        int n = dominoes.length();
        char[] chars = dominoes.toCharArray();
        //新建数组保存结果
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            result[i] = '.';
        }

        //遍历
        //记录上次结束的位置
        int lastEnd = 0;
        for (int i = 0; i < n; i++) {
            //如果找到的是向左边倒的，那么直接把前面的结果全部付成L
            if (chars[i] == 'L'){
                for (int j = lastEnd; j <= i; j++) {
                    result[j] = 'L';
                }
            }else if (chars[i] == 'R'){
                if ( i == n - 1){
                    result[i] = 'R';
                }
                //如果找到的是向右边倒的，那么向右边遍历，如果找到向左倒的，那么将前一半设置为R，后一半设置为L
                //如果向右边找到的第一个不是.的位置是R，那么直接把前面的设置为R
                for (int j = i + 1; j < n; j++) {
                    if (chars[j] == 'R'){
                        for (int k = i; k < j; k++) {
                            result[k] = 'R';
                        }
                        lastEnd = j;
                        i = j - 1;
                        break;
                    }else if (chars[j] == 'L'){
                        int temp = j - i + 1;
                        if (temp % 2 == 0){
                            for (int k = 0; k < temp / 2; k++) {
                                result[i + k] = 'R';
                            }
                            for (int k = temp / 2; k < temp; k++) {
                                result[i + k] = 'L';
                            }
                        }else {
                            for (int k = 0; k < temp / 2; k++) {
                                result[i + k] = 'R';
                            }
                            for (int k = temp / 2 + 1; k < temp; k++) {
                                result[i + k] = 'L';
                            }
                        }
                        lastEnd = j + 1;
                        i = j;
                        break;
                    }

                    if (j == n - 1){
                        for (int k = i; k < n; k++) {
                            result[k] = 'R';
                        }
                        i = n - 1;
                        break;
                    }

                }
            }
        }
        return Arrays.toString(result).replace(",","").replace("]","").replace("[","").replace(" ","");
    }

    public static void main(String[] args) {
        Leetcode838 leetcode838 = new Leetcode838();
        System.out.println(leetcode838.pushDominoes(".L.R.."));
    }
}
