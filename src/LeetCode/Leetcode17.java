package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 * @date 2019/8/19 21:42
 */
public class Leetcode17 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     *
     *
     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    private  ArrayList<String> arrayList = new ArrayList<>(); ;
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        arrayList.add("");
        arrayList.add("");
        arrayList.add("abc");
        arrayList.add("def");
        arrayList.add("ghi");
        arrayList.add("jkl");
        arrayList.add("mno");
        arrayList.add("pqrs");
        arrayList.add("tuv");
        arrayList.add("wxyz");

        iteritor(digits,"",list);
        return list;

    }
    public void iteritor(String digits, String now, List<String> list){
        if (digits.length() <=0){
            list.add(now);

        }else {
            int num = digits.charAt(0) - '0';
            String s = arrayList.get(num);
            for (int i = 0; i < s.length(); i++) {
                iteritor(digits.substring(1,digits.length()),now+s.charAt(i),list);
            }
        }
    }

    public static void main(String[] args) {
        String s = "";
        Leetcode17 leetcode17 = new Leetcode17();
        leetcode17.letterCombinations(s);
    }
}
