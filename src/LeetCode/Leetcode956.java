package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2019/11/17 18:17
 */
//参考别人写的以后通过
public class Leetcode956 {
    static int maxValue = 0;
    //对于每一个数，有两种方式，放在左边，放在右边，不放
    //因此可以采用dfs
    public void dfs(int[] nums, int height1, int height2, int halfSum, int index, int remain){

        //这一步剪枝函数非常关键，如果当前的最大高度已经不可能比已经计算出来的长了，那么就直接返回不用继续计算
        //这里由于我们开始是从大的长度开始取，因此可以减少很多的计算
        if ((height1 + height2 + remain)/2<= maxValue){
            return;
        }
        //如果两边的值相等了，那么进行记录
        if (height1 == height2){
            maxValue = Math.max(maxValue,height1);
        }


        //如果其中一边的高度已经超过了nums数组的一半，那么直接返回，不再计算
        if (height1 > halfSum || height2 > halfSum){
            return;
        }

        //如果已经没有数字可以取了，直接返回
        if (index < 0){
            return;
        }

        //如果剩下的数字不足以填补差
        if (Math.abs(height1 - height2) > remain){
            return;
        }
        //如果剩下的刚好填补差
        if (Math.abs(height1 - height2) == remain){
            maxValue = Math.max(maxValue, Math.max(height1,height2));
        }

        //分类计算
        //放左边
        dfs(nums,height1 + nums[index],height2,halfSum,index - 1,remain - nums[index]);
        //放右边
        dfs(nums,height1,height2+ nums[index],halfSum,index - 1,remain - nums[index]);
        //不放
        dfs(nums,height1,height2,halfSum,index - 1,remain - nums[index]);

    }

    public int tallestBillboard(int[] rods) {

        maxValue = 0;
        if (rods.length == 0){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < rods.length; i++) {
            sum += rods[i];
        }
        Arrays.sort(rods);
        int total = sum;
        sum = sum / 2 + 1;
        dfs(rods,rods[rods.length - 1],0,sum,rods.length - 2,total - rods[rods.length - 1]);
        dfs(rods,0,0,sum,rods.length - 2,total - rods[rods.length - 1]);

        return maxValue;
    }

    public static void main(String[] args) {
        Leetcode956 leetcode956 = new Leetcode956();
        int[] a = new int[]{227,259,250,262,217,280,243,228,244,269,253,228,262,273,240,253,270,242};

        System.out.println(leetcode956.tallestBillboard(a));
    }
}
