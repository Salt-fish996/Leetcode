package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/18 12:54
 */
//看了解答以后写的
public class Leetcode517 {
    /**
     * 超级洗衣机：
     * 要让每一个同种的衣服的数量相等，那么首先条件是让衣服的总数能够平分到每一个洗衣机里面去
     * 然后计算出每一个桶里面应该放的衣服数量，那么与每一个桶里面的衣服数量做差，如果结果为0
     * 表示不需要放入衣服，如果结果为证，则需要向两边放，如果为负数，那么需要从两边取得衣服*/
    public int findMinMoves(int[] machines) {

        int n = machines.length;
        //计算衣服总数
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += machines[i];
        }

        //如果衣服总数不能被均分，那么返回-1，表示没有可能
        if (sum % n != 0){
            return -1;
        }

        //max表示最少移动次数
        int max = 0;
        int partSum = 0;
        int average = sum / n;
        for (int i = 0; i < n; i++) {
            machines[i] = machines[i] - average;
            partSum += machines[i];
            //如果machines是正的，那么一定要至少移动machines[i]次，
            // 但是如果是负的，那么就不一定了，因为可能在前面的移动过程中已经移动过需要的了
            max = Math.max(Math.abs(partSum),Math.max(machines[i],max));

        }

        return max;
    }


    public static void main(String[] args) {
        Leetcode517 leetcode517 = new Leetcode517();
        int[] a = new int[]{0,3,0};
        System.out.println(leetcode517.findMinMoves(a));
    }
}
