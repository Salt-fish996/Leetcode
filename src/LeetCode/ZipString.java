package LeetCode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author hyy
 * @date 2020/3/16 10:07
 */
public class ZipString {
    static int COUNT = 0;
    public String compressString(String S) {

        if (S.length() == 0) {
            return "";
        }
        //将字符串转换为字符数组可以有效减少运算时间
        char[] chars = S.toCharArray();
        char temp = chars[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < S.length(); i++) {
            if (temp != chars[i]) {
                result.append(temp).append(count);
                temp = chars[i];
                count = 1;
            } else {
                count ++;
            }
        }

        result.append(temp).append(count);



        if (result.toString().length() >= S.length()) {
            return S;
        }

        return result.toString();
    }
}
