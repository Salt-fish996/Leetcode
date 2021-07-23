package LeetCode;

public class Leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null ) return false;
        if (root.left == null && root.right == null && sum == root.val )return true;
        boolean flag = false;
        if (root.left != null ){
            flag = hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null ){
            flag = flag || hasPathSum(root.right,sum - root.val);
        }
        return flag;
    }
}
