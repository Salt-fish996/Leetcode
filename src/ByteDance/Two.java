package ByteDance;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2020/3/15 18:59
 */
//100%
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] one = in.nextLine().split(" ");
        long dis = Long.parseLong(one[0]);
        long weight = Long.parseLong(one[1]);
        String[] positionTemp = in.nextLine().split(" ");
        String[] supplyTemp = in.nextLine().split(" ");
        int n = positionTemp.length;
        int[] position = new int[n];
        int[] supply = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = Integer.parseInt(positionTemp[i]);
            supply[i] = Integer.parseInt(supplyTemp[i]);
        }

        //使用动态规划，dp[i]表示i次加油能够走得距离，需要满足dp[i]>=distance的最小值
        long[] dp = new long[n + 1];
        //不加油走得最远距离就是初始状态油的重量
        dp[0] = weight;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= position[i]) {
                    dp[j + 1] =Math.max(dp[j + 1], dp[j] + (long)supply[i]);
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (dp[i] >= dis) {
                System.out.println(i);
                flag = false;
                break;
            }
        }

        if(flag) {
            System.out.println(-1);
        }

    }
}
