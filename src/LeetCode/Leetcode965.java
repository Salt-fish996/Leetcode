package src.LeetCode;

public class Leetcode965 {
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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
           return true;
        }
        return dfs(root,root.val);
    }

    public boolean dfs(TreeNode root,int v) {
          if (root == null) {
              return true;
          }
          if (root.val != v) {
              return false;
          }
          return dfs(root.left,v) && dfs(root.right,v);
    }
}
