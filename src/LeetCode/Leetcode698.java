package LeetCode;

import java.util.Arrays;

/**
 * @author hyy
 * @date 2019/12/2 16:48
 */
//通过，这道题方法很容易想到，但是要优化，先将数组排序，然后从最大的数开始取，这也会很快找到符合条件的分配
//但是如果找不到的情况下是差不多的
public class Leetcode698 {
    public boolean dfs(int[] nums, int k, int[] sum, int index,int big,int average){
        //剪枝，因为每一个分组都要是average，因此如果有一个超出了，那么接下来无论如何分配都不可能分成k个相同值得组合
        if (big > average){
            return false;
        }
        //分配完毕，进行检查，一旦有一个不等，跳出检查返回
        if (index < 0){
            int temp = sum[0];
            for (int i = 0; i < k; i++) {
                if (temp != sum[i]){
                    return false;
                }
            }
            return true;
        }

        //对于nums[index],可以选择分配到sum的k个容器的任意一个，如果有一个分配是成功的，那么就不用再计算别的分配方式了
        for (int i = 0; i < k; i++) {
            sum[i] += nums[index];
            int nowBig = Math.max(big,sum[i]);
            //如果可以分配成功，直接返回
            if (dfs(nums,k,sum,index - 1,nowBig,average)){
                return true;
            }
            sum[i] -= nums[index];
        }

        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int count = 0;
        for (int num : nums) {
            count += num;
        }
        //要分成k个组合，那么数组和必须是k的倍数
        if (count % k !=0){
            return false;
        }
        //相当于有k个容器，对于每一个数，可以选择放在其中的任意一个位置
        //对于第一个数，无论放在哪个容器都是相同的
        int[] sum = new int[k];
        Arrays.sort(nums);
        sum[0] = nums[nums.length - 1];
        return dfs(nums,k,sum,nums.length - 2,nums[nums.length - 1],count / k);
    }

    public static void main(String[] args) {
        Leetcode698 leetcode698 = new Leetcode698();

        int[] a = new int[]{1739,5391,8247,236,5581,11,938,58,1884,823,686,1760,6498,6513,6316,2867};
        long s = System.currentTimeMillis();
        for (int i = 1; i < a.length; i++) {
            s = System.currentTimeMillis();
            System.out.println("能否分成"+i+"个相等的组合:"+leetcode698.canPartitionKSubsets(a,i) +" 花费时间："+ (System.currentTimeMillis() - s));
        }
    }
}
