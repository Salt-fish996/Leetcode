package DynamicAlgor;

public class Jump {
    /*青蛙能不能跳到n-1的位置
    * 首先给出一个数组，里面包含了青蛙下一步可以跳的最大距离
    * jumps[n] = {1,2,3,..}
    * f[i]表示能不能过跳到i位置
    * f[i] = or(0<=j<i){f[j]&&jumps[j]+j>=i)
    * 最后返回f[n-1]*/

    public boolean dp(int[] jumps){
        boolean[] flag = new boolean[jumps.length];
        flag[0] = true;
        for (int i = 0; i < jumps.length; i++) {
            for (int j = 0; j < i; j++) {
                flag[i] = flag[j]&&(jumps[j] + j >= i);
                if (flag[i]) break;
            }
        }
        return flag[jumps.length-1];
    }


    public static void main(String[] args) {
        Jump jump = new Jump();
        int[] jumps = new int[]{2,3,1,1,4};
        int[] jumps2 = new int[]{3,2,1,0,4};
        System.out.println(jump.dp(jumps));
        System.out.println(jump.dp(jumps2));
    }

}
