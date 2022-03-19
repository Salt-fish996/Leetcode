package LeetCode;

public class LeetCode100 {
      public static class TreeNode {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
          if (p == null && q == null) {
              return true;
          }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // 比较左结点
        if (!this.isSameTree(p.left,q.left)) {
            return false;
        }
        // 比较右节点
        if (!this.isSameTree(p.right,q.right)) {
            return false;
        }
        return true;
    }
}
