package src.LeetCode;

/**
 * @author hyy
 * @date 2019/8/1 22:37
 */
public class Leetcode5 {

    /*
    * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    public String longestPalindrome(String s) {
        if (s.length()==0)
            return "";
         int before = 0;            //定义前后指针
        int after =0;
       int begin = 0;
         int end = 0;
       int max = -1;
       int count = 0;


        for (int i = 1;i<s.length();i++){
            before = i-1;
            after = i+1;
            count = 0;

            int flag = 0;
            if (before<0||after>=s.length()){
                count = 1;
                if (count >= max){
                    max = count;
                    begin = before+1;
                    end = after-1;
                }
            }


                    if (before>=0&&after<s.length()&&s.charAt(before)==s.charAt(after)){
                        before--;
                        after++;
                        count = 3;
                        while (true){
                            if (before>=0&&after<s.length()&&s.charAt(before)==s.charAt(after))
                            {
                                count += 2;
                                before--;
                                after++;
                            }else {
                                break;
                            }
                        }
                        if (count >= max){
                            max = count;
                            begin = before+1;
                            end = after-1;
                        }
                        before = i-1;
                        after = i+1;
                    }

                    if (before>=0&&s.charAt(i) == s.charAt(before)) {
                        before--;
                        count = 2;
                        while (true){
                            if (before>=0&&after<s.length()&&s.charAt(before)==s.charAt(after))
                            {
                                count += 2;
                                before--;
                                after++;
                            }else {
                                break;
                            }
                        }
                        if (count >= max){
                            max = count;
                            begin = before+1;
                            end = after-1;
                        }
                        before = i-1;
                        after = i+1;

                    }
                    if (after<s.length()&&s.charAt(i) == s.charAt(after)) {
                        after++;
                        count = 2;
                        while (true){
                            if (before>=0&&after<s.length()&&s.charAt(before)==s.charAt(after))
                            {
                                count += 2;
                                before--;
                                after++;
                            }else {
                                break;
                            }
                        }
                        if (count >= max){
                            max = count;
                            begin = before+1;
                            end = after-1;
                        }
                        before = i-1;
                        after = i+1;
                    }


                }
        return s.substring(begin,end+1);

    }



    public static void main(String[] args) {
        String s = "bc";
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.longestPalindrome(s));
    }


}
