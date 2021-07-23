package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hyy
 * @date 2019/8/19 19:54
 */
public class Leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        allSort(nums,0,result,set);
        return result;
    }

    public void allSort(int[] nums, int index,List<List<Integer>> lists,Set<String> hs){
        if (index == nums.length){
            List a = new ArrayList();
            String s = "";
            for (int i = 0; i < nums.length; i++) {
                a.add(nums[i]);
                s += nums[i];
            }
            if (!hs.contains(s))
            {
                lists.add(a);
                hs.add(s);
            }


        }else {
            for (int i = index; i < nums.length ; i++) {

                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    allSort(nums,index+1,lists,hs);
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
        }
    }
}
