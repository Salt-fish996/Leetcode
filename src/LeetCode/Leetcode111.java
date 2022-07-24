package src.LeetCode;

public class Leetcode111 {
    public int high(TreeNode root){
        if (root.left == null && root.right == null){
            return 1;
        }
        int left = Integer.MAX_VALUE;
        if (root.left != null)
        {
            left= high(root.left);
        }
        int right = Integer.MAX_VALUE;
        if (root.right != null){
            right = high(root.right);
        }



        return Math.min(right,left) + 1;
    }
    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        return high(root);
    }
}
