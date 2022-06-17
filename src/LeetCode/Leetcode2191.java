package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            map.put(Integer.toString(i).charAt(0),mapping[i]);
        }
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        Arrays.sort(newNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map(Integer.toString(o1),map)-map(Integer.toString(o2),map);
            }

        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
        return nums;
    }

    public int map(String num, Map<Character,Integer> map) {
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            res = res*10+map.get(num.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode2191 l = new Leetcode2191();
        System.out.println(Arrays.toString(l.sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{0,1,2,3,4,5,6,7,8,9})));
    }
}
