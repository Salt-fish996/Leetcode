package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hyy
 * @date 2019/11/21 16:06
 */
//weitongguo
public class Leetcode315 {
    //计算右侧小于当前元素的个数
    //要计算右侧小于当前元素的个数
    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]){
                    counts[j] ++;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(counts[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        Leetcode315 leetcode315 = new Leetcode315();
        int[] a = new int[]{5,45,9,1,5,63,6};
        System.out.println(Arrays.toString(leetcode315.countSmaller(a).toArray()));
    }
}
