package LeetCode;

/**给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，
 * 使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 */


/**假设 miss 是缺少的数字中最小的，则区间 [1, miss) (左闭右开) 已经被完全覆盖。为了覆盖 miss，我们需要添加某些小于等于 miss 的数字。否则将不可能覆盖到。

 例如，数组 nums = [1,2,3,8]， n = 16。已经覆盖到的数字有区间 [1, 6] 和 [8, 14]。换而言之，7, 15, 16 没有覆盖到。如果你加的数字大于 7，则 7 依然覆盖不到。

 假设我们添加的数字是 xx，则区间 [1, miss) 和 [x, x + miss) 均被覆盖到。由于我们知道 x <= miss，这两个区间必然覆盖了区间 [1, x + miss)。我们希望能够尽可能选择大的 xx，这样覆盖的范围就可以尽可能大。因此，最好的选择是 x = miss。

 在覆盖到 miss 后，我们可以重新计算覆盖范围，查看新的最小的缺少数字。然后加上该数字。重复操作直到全部数字都被堵盖到。

 下面是这个贪心算法的流程：

 初始化区间 [1, miss) = [1, 1) = 空
 每当 n 没有被覆盖
 若当前元素 nums[i] 小于等于 miss
 将范围扩展到 [1, miss + nums[i])
 将 i 增加 1
 否则
 将 miss 添加到数组，将范围扩展到 [1, miss + miss)
 增加数字的计数
 返回增加数字的数目
 */
import java.util.*;

/**思路(时间复杂度太高）：
 * 由于要算需要添加的最小的值，如果已经给出了当前数组中所有可能的组合值，如当前的所有可以表示的值为[1,3,4]
 * 那么添加了下一个数h以后可以表示的值就是[1,3,4,h,h+1,h+3,h+4],
 * 因此可以采用TreeSet,每次把TreeSet 放入队列中，检测TreeSet中的值是否已经可以表示[1,n]了，如果可以，那么返回，
  *那么就直接返回添加的数字的数目
 * 用一个队列存储TreeSet，用一个存储添加的数*/
public class Leetcode330 {
    private TreeSet<Integer> toTreeSet(int[] arr){
        TreeSet<Integer> treeSet = new TreeSet<>();
        if (arr.length == 0) return treeSet;
        treeSet.add(arr[0]);
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Object[] j = treeSet.toArray();
            treeSet.add(arr[i]);
            for (int k = 0; k < j.length; k++) {
                treeSet.add((int)j[k] + arr[i]);
            }
        }
        return treeSet;
    }
    private int check(TreeSet<Integer> treeSet, int n,int m){
        //检测TreeSet中是否可以表示所有的值[1,n]
        for (int i = m; i <= n; i++) {
            if (!treeSet.contains(i)){
                return i;
            }
        }
        return n+1;
    }
    public int minPatches(int[] nums, int n) {


        Queue<TreeSet> queue = new LinkedList<>();//存储可以表示的数的集合
        Queue<Integer> queueCount = new LinkedList<>();//存储添加的数目
        queue.add(toTreeSet(nums));
        queueCount.add(0);
        int last = 1;
        while (!queue.isEmpty()){
            TreeSet<Integer> temp = queue.poll();
            int count = queueCount.poll();
            int m = check(temp,n,last);
            last = m;
            if (m == n + 1){//如果数组中的数可以表示[1,n],那么直接返回
                return count;
            }else {//如果还不能表示完

                for (int j = 1; j <= m; j++) {
                    TreeSet<Integer> treeSet = new TreeSet<>(temp);
                    treeSet.add(j);
                    for (Integer i:temp
                         ) {
                        treeSet.add(i + j);
                    }
                    queue.add(treeSet);
                    queueCount.add(count + 1);
                }

            }
        }
        return 0;
    }

    //参考答案
    public int minPatches2(int[] nums, int n) {
        int patches = 0, i = 0;
        long miss = 1; // use long to avoid integer overflow error
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) // miss is covered
                miss += nums[i++];
            else { // patch miss to the array
                miss += miss;
                patches++; // increase the answer
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        Leetcode330 leetcode330 = new Leetcode330();
        int[] a = new int[]{1,2,31,33};
        System.out.println(leetcode330.minPatches2(a,2147483647));
    }
}
