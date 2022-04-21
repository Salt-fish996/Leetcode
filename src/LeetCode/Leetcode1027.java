package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1027 {
    public int longestArithSeqLength(int[] nums) {
        // 最长等差子序列
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                max = Math.max(this.dfs(nums,j,nums[j]-nums[i])+2,max);
            }
        }
        return max;
    }

    public int dfs(int[] nums,int index,int cha) {

        for (int i = index+1; i < nums.length; i++) {
            if (nums[i] - nums[index] == cha) {
                return this.dfs(nums,i,cha) + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode1027 l = new Leetcode1027();
        System.out.println(l.longestArithSeqLength(new int[]{3,6,9}));
    }
}
