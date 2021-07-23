package DynamicAlgor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BagProblem {
    /*01背包问题，背包容量为W，一共有n件物品，第i个物品的价值是v[i]，重量是w[i]
    * 要求得到的价值最大
    * 使用二维数组maxValue[n][w]来表示最优值,那么对于第i个商品，maxValue[i][j] = max{maxValue[i-1][j],maxValue[i-1][j-w[i]] + v[i]}*/
    public int dp(int[] v,int[] w,int W){

        int n = v.length;
        int[][] maxValue = new int[n][W+1];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < W + 1; j++) {
                if ( i == 0 || j == 0) maxValue[i][j] = 0;
                else {
                    if (j-w[i]>=0){
                        //这就是动态规划的核心，当要计算当前书包重量为j，放到第i个物品的时候，他的最大的价值只可能来源于已经放了第i个物品放进
                        //去的价值maxValue[i-1][j-w[i]] + v[i]或者没有放第i个物品的价值maxValue[i-1][j]中的最大值
                        maxValue[i][j] = Math.max(maxValue[i-1][j], maxValue[i-1][j-w[i]] + v[i]);
                    }else {
                        maxValue[i][j] = maxValue[i-1][j];
                    }
                }
            }
        }

        return maxValue[n-1][W];
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        ListIterator<Integer> integerIterator = (ListIterator<Integer>) list.listIterator();
        integerIterator.add(30);
        int j = 0;
        while (integerIterator.hasNext()){
            System.out.println("...  " + integerIterator.next());
            if (j++ == 5){
                integerIterator.remove();
            }

        }

        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
        int[] w = new int[]{0,2,3,4,5};
        int[] v = new int[]{0,3,4,5,6};
        BagProblem bagProblem = new BagProblem();
        System.out.println(bagProblem.dp(v,w,8));
    }
}
