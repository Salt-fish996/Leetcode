package src.LeetCode;

public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
         int index = nums.length-1;
         int i = 0;
         while (true) {
             if (index < i) {
                 return i;
             }
             if (nums[i] == val) {
                 nums[i] = nums[index];
                 index--;
             } else {
                 i++;
             }
         }
    }

    public static void main(String[] args) {
        Leetcode27 l = new Leetcode27();
        System.out.println(l.removeElement(new int[]{0,1,2,2,3,0,4,2} ,3));
    }
}
