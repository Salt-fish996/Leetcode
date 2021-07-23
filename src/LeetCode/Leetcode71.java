package LeetCode;

import java.util.Arrays;
import java.util.Stack;

//简化路径,通过
public class Leetcode71 {
    public String simplifyPath(String path) {

        //使用栈
        Stack<String> strings = new Stack<>();
        //切割路径
        String[] strings1 = path.split("/");
        System.out.println(Arrays.toString(strings1));
        int n = strings1.length;
        if (n == 0){
            return "/";
        }
        for (int i = 0; i < n; i++) {

            //如果是/..那么去上一个目录，也就是从栈中取出一个字符串
            if (strings1[i].equals("")){
                if (!strings.isEmpty()){
                    strings.pop();
                }
            }else if (!strings1[i].equals(".") && !strings1[i].equals("")&&strings1[i].length()>=1){
                strings.push(strings1[i]);
            }
        }
        if (strings.size() == 0){
            return "/";
        }
        String r = "";
        while (!strings.isEmpty()){
            r = strings.pop() +"/"+ r;
        }
        r="/"+r;

        return r.substring(0,r.length()-1);
    }

    public static void main(String[] args) {
        Leetcode71 leetcode71 = new Leetcode71();
        System.out.println(leetcode71.simplifyPath("/home//foo/"));
    }
}
