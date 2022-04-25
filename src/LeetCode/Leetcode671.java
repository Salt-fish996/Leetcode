package src.LeetCode;

import java.util.*;

public class Leetcode671 {
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
   int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
       dfs(root, root.val);
       return ans;
    }
    public void dfs(TreeNode n,int min) {
        if (n == null) {
            return;
        }
        if (n.val > min) {
            if (ans == -1) {
                ans = n.val;
            }else if (ans > n.val) {
                ans = n.val;
            }
        }
        dfs(n.left,min);
        dfs(n.right,min);
    }
}
