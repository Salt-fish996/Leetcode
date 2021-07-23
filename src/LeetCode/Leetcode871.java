package LeetCode;

/**
 * @author hyy
 * @date 2019/11/30 17:36
 */
public class Leetcode871 {
    //时间复杂度太高
    private static int minCount = Integer.MAX_VALUE;
    //使用dfs+剪枝
    //对于路过的每一个加油站，可以选择加油或者是不加油
    /**
     * @param target 表示目标点
     * @param nowFuel 表示现在车里面的油
     * @param stations 加油站信息
     * @param count 当前已经加油的次数
     * @param nowIndex 当前所在加油站位置*/
    public void dfs(int target, int nowFuel, int[][] stations,int count,int nowIndex,int nowDistance){
        System.out.println("nowFuel:" + nowFuel + " nowIndex:"+nowIndex + " count:"+count);
        //如果到达的时候已经没有油了，那么表示不能够继续走下去
        if (nowFuel < 0){
            return;
        }
        //如果当前算出来的加油次数已经比记录的加油次数多，那么表示一定不符合
        if (count > minCount){
            return;
        }
        //如果现在的油已经能够直接到达目的地了
        if (nowIndex == -1){
            //还没有经过任何加油站,就能够直接到达目的地，那就不用加油了
            if (nowFuel >= target){
                minCount = 0;
            }else if (stations.length != 0){
                //刚出发的时候是不能加油的，必须到达下一站才加
                dfs(target,nowFuel - stations[0][0],stations,count,nowIndex + 1,stations[0][0]);
            }
        }else {
            //如果能够从当前位置直接到达target,那么直接到达
            if (nowFuel >= target - stations[nowIndex][0]){
                minCount = Math.min(minCount,count);
                return;
            }else {
                if (nowIndex + 1 < stations.length){
                    //如果还有加油站的情况下
                    //不能够到达的时候，可以选择加油或者不加油
                    dfs(target,nowFuel + stations[nowIndex][1] - (stations[nowIndex + 1][0] - nowDistance),stations,count + 1,nowIndex + 1,stations[nowIndex + 1][0]);
                    dfs(target,nowFuel - (stations[nowIndex + 1][0] - nowDistance),stations,count,nowIndex + 1,stations[nowIndex + 1][0]);
                }else {
                    //如果已经没有加油站了
                    if (nowFuel + stations[nowIndex][1] >= target - nowDistance){
                        minCount = Math.min(minCount,count + 1);
                    }
                }
            }
        }
    }
    public int minRefuelStops1(int target, int startFuel, int[][] stations) {

        minCount = Integer.MAX_VALUE;
        dfs(target,startFuel,stations,0,-1,0);
        return minCount == Integer.MAX_VALUE?-1:minCount;
    }

    //动态规划
    //使用dp[i]来表示加i次油能够到达的最远位置
    //参考官方解答
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        //加油站的个数，最多也只能够加这么多次油
        int n = stations.length;

        if ( n == 0){
            if (startFuel >= target){
                return 0;
            }else {
                return -1;
            }
        }
        int[] dp = new int[n + 1];
        //初始化状态数组
        dp[0] = startFuel;

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (dp[j] >= stations[i][0]){
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode871 leetcode871 = new Leetcode871();
        int[][] a = new int[4][2];
        a[0] = new int[]{50,50};
        a[1] = new int[]{20,30};
        a[2] = new int[]{30,20};
        a[3] = new int[]{60,40};

        int[][] b = new int[0][0];
        System.out.println(leetcode871.minRefuelStops(110,50,a));
    }
}
