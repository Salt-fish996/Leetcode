package LeetCode;

import java.util.HashSet;
import java.util.Set;
//数组嵌套，通过
public class Leetcode565 {
    public int arrayNesting(int[] nums) {

        //记录最大值
        int max = 0;
        //记录已经存储过了的位置
        Set<Integer> set = new HashSet<>();
        //记录读取了的nums位置
        int n = nums.length;
        int[] record = new int[n];
        for (int i = 0; i < n; i++) {
            if (record[i] != 1){
                set.clear();
                int sum = 0;//记录值
                int sit = i;//记录位置
                while (!set.contains(sit)){
                    set.add(sit);
                    sit = nums[sit];
                    record[sit] = 1;
                    sum++;
                }
                max = Math.max(max,sum);
            }

        }
        return max;
    }
}
