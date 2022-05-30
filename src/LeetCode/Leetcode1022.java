package src.LeetCode;

public class Leetcode1022 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        this.res = 0;
        dfs(root,0);
        return res;
    }
    public void dfs(TreeNode root, int v) {
        if (root.left != null) {
            dfs(root.left,2*v+root.val);
        }
        if (root.right != null) {
            dfs(root.right,v*2+root.val);
        }
        if (root.left == null && root.right == null) {
            res += v*2+root.val;
        }
    }
}
