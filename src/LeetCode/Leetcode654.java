package src.LeetCode;

public class Leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length-1);

    }
    public TreeNode dfs(int[] nums, int begin,int end) {
        if (begin > end) {
            return null;
        }
        int max = -1;
        int maxIndex = -1;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = dfs(nums,begin,maxIndex-1);
        root.right = dfs(nums,maxIndex+1,end);
        return root;
    }

    public static void main(String[] args) {
        Leetcode654 l = new Leetcode654();
        System.out.println(l.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }
}
