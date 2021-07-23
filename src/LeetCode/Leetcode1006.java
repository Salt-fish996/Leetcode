package LeetCode;

/**
 * @author hyy
 * @date 2019/11/22 12:22
 */
//笨阶乘,通过，可以优化
public class Leetcode1006 {
    public int clumsy(int N) {

        int i = N;
        //记录总的值
        int sum = 0;
        StringBuffer stringBuffer = new StringBuffer("");
        while (i > 0){

            //计算*/
            int temp = i--;
            if (i > 0){
                temp *= i--;
            }
            if (i>0){
                temp /= i--;
            }
            stringBuffer.append(temp);
            if (i > 0){
                stringBuffer.append(" + ").append(i--);
            }
            if (i > 0){
                stringBuffer.append(" - ");
            }
        }
        System.out.println(stringBuffer.toString());
        String[] s = stringBuffer.toString().split(" ");
        sum = Integer.parseInt(s[0]);
        for (int j = 1; j < s.length; j++) {
            if (s[j].equals("+")){
                sum += Integer.parseInt(s[j+1]);
            }else {
                sum -= Integer.parseInt(s[j+1]);
            }
            j++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Leetcode1006 leetcode1006 = new Leetcode1006();
        System.out.println(leetcode1006.clumsy(20));
    }
}
