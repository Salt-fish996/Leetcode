package LeetCode;

public class Leetcode55 {
    //用boolean数组flag[i]来表示i位置上的点是否可以到达
    //flag[i] = (i-j)<=nums[j]?flag[j]:false,一旦flag[i]=true,返回
    public boolean canJump(int[] nums) {

        int n = nums.length;
        boolean[] flag = new boolean[n];
        flag[0] = true;
        for (int i = 1; i < n; i++) {
            flag[i] = false;
            for (int j = 0; j < i; j++) {
                flag[i] = ((i - j) <= nums[j] && flag[j]);
                if (flag[i]){
                    break;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(flag[i]);
//        }
        return flag[n - 1];
    }


    //复杂度为O(N)的算法
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        Leetcode55 leetcode55 = new Leetcode55();
        int[] b = new int[]{3,2,1,0,4};
        System.out.println(leetcode55.canJump(b));
        int[] a = new int[]{2,3,1,1,4};
        System.out.println(leetcode55.canJump(a));

    }
}
