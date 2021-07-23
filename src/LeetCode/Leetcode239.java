package LeetCode;


//滑动窗口，通过，时间比较长
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n+1-k];

        if (n == 0){
            return new int[0];
        }

        int max = Integer.MIN_VALUE;
        int lastMax = Integer.MIN_VALUE;
        for (int i = 0; i < k && i < n; i++) {
            max = Math.max(max,nums[i]);
            if (i>0){
                lastMax = Math.max(lastMax,nums[i]);
            }
        }
        result[0] = max;
        int count = 1;
        for (int i = k; i < n; i++) {
            result[count] = Math.max(lastMax,nums[i]);
            if (lastMax != result[count]){
                lastMax = result[count];
            }else {
                lastMax = Integer.MIN_VALUE;
                for (int j = i; j >i-k+1 ; j--) {
                    lastMax = Math.max(nums[j],lastMax);
                }
            }
            count++;
        }
        return result;
    }
}
