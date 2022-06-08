package src.LeetCode;

public class Leetcode1325 {
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        boolean left = dfs(root.left,target,root,true);
        boolean right =dfs(root.right,target,root,false);
        if ( left && right) {
            if (root.val == target) {
                return null;
            }
            return root;
        }
        return root;
    }

    public boolean dfs(TreeNode root ,int target,TreeNode parent,boolean isLeft) {
          if (root == null) {
              return true;
          }
          boolean leftRemove = root.left == null;
        boolean rightRemove = root.right == null;
        if (root.left != null) {
              leftRemove = dfs(root.left,target,root,true);
          }
        if (root.right != null) {
            rightRemove = dfs(root.right,target,root,false);
        }
        if (leftRemove && rightRemove && root.val == target) {
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode1325 l = new Leetcode1325();
        TreeNode t1 = new Leetcode1325().new TreeNode(1);
        TreeNode t2 = new Leetcode1325().new TreeNode(3);
        TreeNode t3 = new Leetcode1325().new TreeNode(3);
        TreeNode t4 = new Leetcode1325().new TreeNode(3);
        TreeNode t5 = new Leetcode1325().new TreeNode(2);
        t1.left = t2;
        t2.left = t3;
        t2.right = t5;
        t1.right=t4;
        System.out.println(l.removeLeafNodes(t1,3));
    }
}
