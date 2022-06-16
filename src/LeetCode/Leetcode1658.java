package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1658 {
    int res;
    HashMap<String,Integer> map;
    public int minOperations1(int[] nums, int x) {
        res = Integer.MAX_VALUE;
        map = new HashMap<>();
        dfs(nums,x,0,nums.length-1,0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }
    public int dfs(int[] nums,int x, int left,int right,int count) {
        String s = x+"-"+left+"-"+right;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (count >= res || x < 0) {
            return res;
        }
        if (left > right) {
            return res;
        }
        if (x - nums[left] == 0 || x - nums[right] == 0) {
            res = Math.min(count+1,res);
            return res;
        }

        int l = dfs(nums,x-nums[left],left+1,right,count+1);
        l = Math.min(l,dfs(nums,x-nums[right],left,right-1,count+1));
        map.put(s,l);
        return l;
    }


    public int minOperations(int[] nums, int x) {
       HashMap<Integer,Integer> left = new HashMap<>();
       HashMap<Integer,Integer> right = new HashMap<>();
       int res =0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            left.put(res,i+1);
        }
        if (res < x) {
            return -1;
        }
        if (res == x) {
            return nums.length;
        }
        res = 0;
        for (int i = nums.length-1; i >=0 ; i--) {
            res+= nums[i];
            right.put(res,nums.length-i);
        }
        res = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> entry:left.entrySet()
             ) {
            int v = entry.getKey();
            if (right.containsKey(x-v)) {
                res = Math.min(res,entry.getValue()+right.get(x-v));
            }
        }
        if (left.containsKey(x)) {
            res = Math.min(res,left.get(x));
        }
        if(right.containsKey(x)) {
            res = Math.min(res,right.get(x));
        }
        return res == Integer.MAX_VALUE?-1:res;
    }

    public static void main(String[] args) {
        Leetcode1658 l = new Leetcode1658();
        System.out.println(l.minOperations(new int[]{1,1,4,2,3},5));
    }
}
