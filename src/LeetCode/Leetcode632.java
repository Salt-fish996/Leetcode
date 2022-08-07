package src.LeetCode;

public class Leetcode632 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        dfs(root,val,depth,1);
        return root;
    }

    public void dfs(TreeNode root,int val,int depth,int level) {
        if (root == null) {
            return;
        }
        if (level == depth - 1) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode n1 = new TreeNode(val);
            root.left = n1;
            n1.left = left;
            TreeNode n2 = new TreeNode(val);
            root.right = n2;
            n2.right = right;
            return;
        }
        dfs(root.left,val,depth,level+1);
        dfs(root.right,val,depth,level+1);
    }
}
