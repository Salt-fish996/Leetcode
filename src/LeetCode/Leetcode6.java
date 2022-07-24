package src.LeetCode;

/**
 * @author hyy
 * @date 2019/8/12 21:01
 */
public class Leetcode6 {
    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public String convert(String s, int numRows) {

        if (s.length()==0) return "";
        if (numRows == 1) return s;


        int begin = 0;
        String str = "";
        for (int i = 0; i < numRows && i<s.length(); i++) {
            begin = i;
            boolean upordown = false;//true向上

            str += s.charAt(i);
            for ( ; begin < s.length();) {
                if (!upordown && (begin+(numRows-i-1)*2)<s.length()){
                    if ((numRows-i-1)*2!=0){
                        str += s.charAt(begin+(numRows-i-1)*2);
                        begin = begin+(numRows-i-1)*2;
                    }
                    upordown = true;
                }else if (upordown && begin+(i*2)<s.length()){
                    if (i*2!=0)
                    {
                        str += s.charAt(begin+(i*2));
                        begin = begin+(i*2);
                    }
                    upordown = false;
                }else break;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "mA";
        Leetcode6 leetcode07 = new Leetcode6();
        System.out.println(leetcode07.convert(s,3));
    }
}
