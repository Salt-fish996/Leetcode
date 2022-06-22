package src.LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Leetcode513 {
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
    int maxDeepValue;
    public int findBottomLeftValue(TreeNode root) {
          this.maxDeepValue = root.val;
          dfs(root,1,1);
          return this.maxDeepValue;
    }

    public int dfs(TreeNode root,int max, int level){
          if (root == null) {
              return max;
          }
          if (level > max) {
              max = level;
              this.maxDeepValue = root.val;
          }
          max = dfs(root.left,max,level+1);
          max = dfs(root.right,max,level+1);
          return max;
    }
}
