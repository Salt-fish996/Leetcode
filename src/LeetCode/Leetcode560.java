package src.LeetCode;

import java.util.HashMap;

/**
 * @author hyy
 * @date 2020/3/19 12:54
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        //使用前缀和的方式，使用sum记录当前位置i的总和，将其放入到hashset中，
        //如果后面出现了sum + k的时候，那么就证明存在一个组合为K
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        hashMap.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //如果存在sum-k在hashMap中，那么就是一个解
            if (hashMap.keySet().contains(sum - k)) {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Leetcode560 leetcode560 = new Leetcode560();
        System.out.println(leetcode560.subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0},0));
    }
}
