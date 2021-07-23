package LeetCode;

/**
 * @author hyy
 * @date 2019/8/10 21:16
 */
public class Leetcode08 {
    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     *
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     *
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     *
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * 说明：
     *
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public int myAtoi(String str) {

        int result = 0;
        boolean flag = true;//表示有没有负号，true表示正数
        int situation = 0;
        while (situation < str.length() && str.charAt(situation) == ' '){
            situation++;
        }
        if (situation < str.length()&&str.charAt(situation) == '-'){
            situation++;
            flag = false;

        }else
        if (situation < str.length()&&str.charAt(situation) == '+'){
            situation++;
            flag = true;
        }
        int begin = situation;
        if (situation == str.length()) return 0;
        try{
            while (situation < str.length() && str.charAt(situation) >= '0' && str.charAt(situation) <= '9'){
                situation++;
            }
            String temp = str.substring(begin,situation);
            if (temp.length() == 0) return 0;

            return flag?Integer.valueOf(temp):(-1*Integer.valueOf(temp));
        }catch (Exception e){
            //e.printStackTrace();
            return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }

    }

    public static void main(String[] args) {
        System.out.println("最小：" + Integer.MIN_VALUE);
        System.out.println("最大：" + Integer.MAX_VALUE);
        String s = "-++2";
        Leetcode08 leetcode08 = new Leetcode08();
        System.out.println(leetcode08.myAtoi(s));
    }
}
