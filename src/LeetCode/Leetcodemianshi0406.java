package src.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcodemianshi0406 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  TreeNode res = null;
      boolean has = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
       dfs(root,p);
       return res;
    }

    public boolean dfs(TreeNode root,TreeNode p) {
          if (root == null) {
              return false;
          }


          if (dfs(root.left,p)) {
              return true;
          }
        if (has) {
            res = root;
            has = false;
            return true;
        }
          if (root.val == p.val ) {
              has = true;
          }
          return dfs(root.right, p);
    }

    public static void main(String[] args) {
        Leetcodemianshi0406 l = new Leetcodemianshi0406();
        TreeNode t1 = new Leetcodemianshi0406().new TreeNode(1);
        TreeNode t2 = new Leetcodemianshi0406().new TreeNode(2);
        TreeNode t3 = new Leetcodemianshi0406().new TreeNode(3);
        t2.left = t1;
        t2.right = t3;
        System.out.println(l.inorderSuccessor(t2,t1));
    }
}
