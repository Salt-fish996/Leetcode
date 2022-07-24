package src.LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2019/8/19 20:06
 */
public class Leetcode22 {
    /**
     *给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */
    public List<String> generateParenthesis(int n) {

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        find(list,1,0,"(",n,set);
        return list;
    }

    public void iterator(List<String> l, int left, int right, String h,int n,Set<String> set){
        if ( left==n){
            String temp = h;
                for (int i = 1; i <= n-right; i++)
                    temp += ")";
            if (set.contains(h))
                return;
            l.add(temp);
            set.add(h);
        }else {
            if (left>right)//如果左括号数大于右括号数
            {
                String temp = h;
                for (int i = 1; i <= left-right; i++) {
                    temp += ")";
                    iterator(l,left,right+i,temp,n,set);
                }
            }
            String temp = h;
            for (int i = 1; i <= n-left; i++) {
                temp += "(";
                iterator(l,left+i,right,temp,n,set);
            }
        }
    }

    public void find(List<String> l, int left, int right, String h,int n,Set<String> set){
        if (right > left || left>n ) return;
        if (right == left && right== n){
            l.add(h);
        }else
        find(l,left+1,right,h+"(",n,set);
        find(l,left,right+1,h+")",n,set);
    }

    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        leetcode22.generateParenthesis(16);
    }
}
