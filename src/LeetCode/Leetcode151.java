package src.LeetCode;

public class Leetcode151 {
    public String reverseWords(String s) {

        if (s.length() == 0) return "";
        String[] str = s.split(" ");
        String result = "";
        boolean flag = true;
        for (int i = str.length-1; i >=0; i--) {
            if (!str[i].replace(" ","").equals("")){
                result += str[i] + " ";
            }
        }
        if (result.length()==0) return "";
        return result.substring(0,result.length()-1);
    }

    public static void main(String[] args) {
        Leetcode151 leetcode151 = new Leetcode151();
        String s = "the sky is blue";
        System.out.println(leetcode151.reverseWords(s));
    }
}
