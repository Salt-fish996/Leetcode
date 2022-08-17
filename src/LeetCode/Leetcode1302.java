package src.LeetCode;

public class Leetcode1302 {
    int maxDeep;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        this.maxDeep = 0;
        this.sum = 0;
        dfs(root,0);
        return this.sum;
    }

    public void dfs(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (deep > this.maxDeep) {
            this.maxDeep = deep;
            this.sum = root.val;
        }else if (deep == this.maxDeep) {
            this.sum += root.val;
        }
        dfs(root.left,deep+1);
        dfs(root.right,deep+1);
    }
}
