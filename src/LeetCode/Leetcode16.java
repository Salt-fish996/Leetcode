package src.LeetCode;

/**
 * @author hyy
 * @date 2019/11/18 13:21
 */
public class Leetcode16 {
    static int sum = 0;
    static int cha = Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {

        sum = 0;
        cha = Integer.MAX_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j){
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j){
                        continue;
                    }
                    int nowSum = nums[i] + nums[j] +nums[k];
                    int nowcha = Math.abs(nowSum - target);
                    sum = nowcha<cha?nowSum:sum;
                    cha = Math.min(nowcha, cha);


                }
            }
        }
        return sum;
    }
}
