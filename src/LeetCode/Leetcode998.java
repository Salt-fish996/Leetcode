package src.LeetCode;

public class Leetcode998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        root.right = insertIntoMaxTree(root.right,val);
        return root;
    }
}
