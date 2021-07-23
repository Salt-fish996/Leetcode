package LeetCode;

/**
 * @author hyy
 * @date 2019/8/14 21:04
 * 这个题没有通过
 */
public class Leetcode10 {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * 说明:
     *
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 示例 1:
     *
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     *
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3:
     *
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4:
     *
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5:
     *
     * 输入:
     * s = "mississippi"
     * p = "mis*is*p*."
     * 输出: false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public boolean isMatch(String s, String p) {


            int j = 0;
        return matchByIteritor(s,p,0,0);
    }

    public boolean matchByIteritor(String s,String p,int begin,int y){
        int i = begin;
        for (; i < s.length(); i++,y++) {
            if(y>=p.length()) return false;
            if (p.charAt(y) != s.charAt(i)){
                if (p.charAt(y) == '*'){
                    return matchByIteritor(s,p,i,y-1)
                            || matchByIteritor(s,p,i,y+1);
                }else if (p.charAt(y) == '.'){
                    if (i == s.length()-1 && p.charAt(p.length()-1)=='*') return true;
                    return matchByIteritor(s,p,i+1,y+1);
                }else if (y < p.length()-1 && p.charAt(y+1) == '*'){
                    return matchByIteritor(s,p,i,y+2);
                }else return false;
            }
        }
        if (i > s.length()-1 && y<p.length()){
            for (int j = y; j < p.length(); j++) {
                if (p.charAt(j) !='*' && (j+1>= p.length() || p.charAt(j+1)!='*'))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bbbba";
        String p = ".*a*a";
        Leetcode10 leetcode10 = new Leetcode10();
        System.out.println(leetcode10.isMatch(s,p));
    }
}
