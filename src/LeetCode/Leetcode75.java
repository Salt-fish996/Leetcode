package src.LeetCode;

//颜色分类，通过
public class Leetcode75 {
    public void sortColors(int[] nums) {

        //使用一个数组来存储0,1,2的个数
        int[] counts = new int[3];

        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (counts[j] >0){
                    counts[j]--;
                    nums[i] = j;
                    break;
                }
            }
        }
    }
}
