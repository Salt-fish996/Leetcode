package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode905 {
//    public int[] sortArrayByParity1(int[] nums) {
//        if (nums.length == 1) {
//            return nums;
//        }
//        int left = 0;
//        int right = nums.length - 1;
//        for (int i = 0; i < nums.length ; ) {
//            if (nums[i] % 2 ==0) {
//                if (i == left) {
//                    i++;
//                    left++;
//                    continue;
//                }
//                int t = nums[left];
//                nums[left] = nums[i];
//                nums[i] = t;
//                left++;
//            } else if (nums[i] %2 == 1){
//                int t = nums[right];
//                nums[right] = nums[i];
//                nums[i] = t;
//                right--;
//                if (i == right) {
//                    break;
//                }
//            }
//            if (left <= right) {
//                break;
//            }
//        }
//        return nums;
//    }

    public int[] sortArrayByParity(int[] nums) {
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                l.add(nums[i]);
            } else {
                r.add(nums[i]);
            }
        }
        int n = l.size();
        for (int i = 0; i < n; i++) {
            nums[i] =l.get(i);
        }
        n = r.size();
        for (int i = 0; i < n; i++) {
            nums[i] = r.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        Leetcode905 l = new Leetcode905();
        System.out.println(Arrays.toString(l.sortArrayByParity(new int[]{3,1,2,4,0})));
    }
}
