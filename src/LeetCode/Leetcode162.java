package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/20 18:33
 */

//通过
public class Leetcode162 {
    //如果nums[i]<nums[i+1],那么i =i+1
    //如果nums[i]>nums[i+1]但是nums[i]<nums[i-1],那么i=i+2
    public int findPeakElement(int[] nums) {


        int n = nums.length;
        if (n == 1){
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0){
                if (nums[i] > nums[1]){
                    return i;
                }
            }else if (i == n - 1){
                if (nums[i] > nums[i - 1]){
                    return i;
                }
            }else {
                if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]){
                    return i;
                }else if (nums[i] > nums[i + 1]){
                    i++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Leetcode162 leetcode162 = new Leetcode162();
        System.out.println(leetcode162.findPeakElement(new int[]{1,2,3,1}));
    }
}
