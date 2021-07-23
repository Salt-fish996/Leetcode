package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 * @date 2019/8/14 20:44
 */
public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        allSort(nums,0,result);
        return result;
    }

    public void allSort(int[] nums, int index,List<List<Integer>> lists){
        if (index == nums.length){
            List a = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                a.add(nums[i]);
            }
            lists.add(a);
        }else {
            for (int i = index; i < nums.length; i++) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                allSort(nums,index+1,lists);
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        Leetcode46 leetcode46 = new Leetcode46();
        leetcode46.permute(a);
    }
}
