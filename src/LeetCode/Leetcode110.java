package src.LeetCode;

//判断平衡二叉树
public class Leetcode110 {
    public int high(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = high(root.left);
        if (left == Integer.MIN_VALUE) return left;
        int right = high(root.right);
        if (right == Integer.MIN_VALUE) return right;
        if (Math.abs(left - right)>1){
            return  Integer.MIN_VALUE;
        }

        return (Math.max(left, right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {

        int n = high(root);
        if (n == Integer.MIN_VALUE)
            return false;
        else return true;
    }
}
