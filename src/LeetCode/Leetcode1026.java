package src.LeetCode;

public class Leetcode1026 {
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root,root.val,root.val);
        return this.max;
    }

    public void dfs(TreeNode root,int max,int min) {
        if (root == null) {
            return;
        }
        this.max = Math.max(Math.abs(max-root.val),this.max);
        this.max = Math.max(Math.abs(min-root.val),this.max);
        max = Math.max(root.val,max);
        min = Math.min(root.val,min);
        dfs(root.left,max,min);
        dfs(root.right,max,min);
    }
}
