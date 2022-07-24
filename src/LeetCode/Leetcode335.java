package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/22 10:26
 */

//相交，通过
public class Leetcode335 {
    //第一种情况是不断的向外面绕圈，那么这时候只需要保持每一一次横向的距离逗比上一次小就好了
    //但是如果在走到某一次以后，他可以在先前走过的路径里面走,这个时候每走一步都要比上一部小
    public boolean isSelfCrossing(int[] x) {

        int n = x.length;
        //记录上一次走的横向距离
        int lRow= 0;

        //记录上一次走的纵向距离
        int lDirect = 0;

        //记录上上一次的横向距离
        int lastLRow = 0;
        //记录上上一次的纵向距离
        int lastLDirect = 0;

        int i = 0;

        boolean direction = true;//表示横向走还是纵向走，true表示纵向走
        while (i < n){
            //向外绕圈的时候
            if (direction){
                //纵向走
                if (x[i] > lDirect){
                    lastLDirect = lDirect;
                    lDirect = x[i++];
                    direction = false;
                }else break;
            }else {
                //横向走
                if (x[i] > lRow){
                    lastLRow = lRow;
                    lRow = x[i++];
                    direction = true;
                }else break;
            }
        }

        //限制纵向距离
        int limitDir = 0;
        //限制横向距离
        int limitRow = 0;
        //如果不相交
        if (i == n){
            return false;
        }

        if (direction){
           if (lDirect - lastLDirect > x[i]){
               limitRow = lRow;
           }else
            limitRow = lRow - lastLRow;
            limitDir = x[i] + 1;
        }else {
            if (lRow - lastLRow > x[i])
            {
                limitDir = lDirect;
            }else {
                limitDir = lDirect -lastLDirect;
            }
            limitRow = x[i] + 1;
        }

        lDirect = Integer.MAX_VALUE;
        lRow = Integer.MAX_VALUE;

        while (i < n){
            //向内绕圈的时候
            if (direction){
                //纵向走
                if (x[i] < limitDir && x[i] < lDirect){
                    lDirect = x[i++];
                    direction = false;
                }else break;
            }else {
                //横向走
                if (x[i] < limitRow && x[i] < lRow){
                    lRow = x[i++];
                    direction = true;
                }else break;
            }
        }

        return i != n;
    }


    public static void main(String[] args) {
        Leetcode335 leetcode335 = new Leetcode335();
        int[] a = new int[]{3,3,4,2,2};
        System.out.println(leetcode335.isSelfCrossing(a));
    }
}
