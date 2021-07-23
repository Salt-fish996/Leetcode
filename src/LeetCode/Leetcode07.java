package LeetCode;

/**
 * @author hyy
 * @date 2019/8/10 21:04
 */
public class Leetcode07 {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public int reverse(int x) {
        boolean flag = x>0?true:false;
        String temp = "" + Math.abs(x);
        String result = "";
        int i = 0;
        while (temp.charAt(i) == 0){
            i++;
        }
        for (int j = temp.length()-1 ; j >= i; j--) {
            result += temp.charAt(j);
        }
        try {
            return flag?(Integer.valueOf(result)):(-1*Integer.valueOf(result));
        }catch (Exception e){
            return 0;
        }


    }

    public static void main(String[] args) {
        Leetcode07 leetcode07 = new Leetcode07();
        System.out.println(leetcode07.reverse(-12395798));
    }
}
