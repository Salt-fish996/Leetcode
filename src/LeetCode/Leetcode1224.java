package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1224 {
    public int maxEqualFreq(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            count.put(entry.getValue(),count.getOrDefault(entry.getValue(),0)+1);
        }
        return check(nums,map,count,nums.length-1);
    }

    public int check(int[] nums,Map<Integer,Integer> map,Map<Integer,Integer> count,int index) {
        if (map.size() <= 1) {
            return index+1;
        }
        if (count.size() == 2) {
            int t = 0;
            for (Map.Entry<Integer,Integer> entry:count.entrySet()
                 ) {
                if (entry.getKey() == 1 && entry.getValue() == 1) {
                    return index+1;
                }
                if (entry.getValue() == 1) {
                    if (count.containsKey(entry.getKey()-1)) {
                        return index+1;
                    }
                }
            }
        }
        if (count.size() <= 1 && count.containsKey(1)) {
            return index+1;
        }
        int c = map.get(nums[index]);
        int cc = count.get(c);
        if (cc == 1) {
            count.remove(c);
        } else {
            count.put(c,cc-1);
        }
        if (c-1 >0) {
            count.put(c-1,count.getOrDefault(c-1,0)+1);
            map.put(nums[index],c-1);
        }else {
            map.remove(nums[index]);
        }
        return check(nums,map,count,index-1);
    }

    public static void main(String[] args) {
        Leetcode1224 l = new Leetcode1224();
        System.out.println(l.maxEqualFreq(new int[]{1,1,1,2,2,2}));
    }
}
