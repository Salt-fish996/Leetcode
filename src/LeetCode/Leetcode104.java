package src.LeetCode;

public class Leetcode104 {
    public int high(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = high(root.left);
        int right = high(root.right);
        return (Math.max(left, right)) + 1;
    }
    public int maxDepth(TreeNode root) {

        return high(root);
    }
}
