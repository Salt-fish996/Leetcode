package src.LeetCode;

public class Leetcode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int count = 0;
        int n = nums.length;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(nums[i] < k){
                count++;
                int j = i +1;
                int sum = nums[i];

                while (j<n){
                    if (sum*nums[j] < k){
                        count++;
                        sum *= nums[j];
                        j++;
                    }else break;
                }
            }
        }
        return count;
    }

    //参考答案
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode713 leetcode713 = new Leetcode713();
        int[] a = new int[]{10,5,2,6};
        System.out.println(leetcode713.numSubarrayProductLessThanK(a,100));
    }
}
