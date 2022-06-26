package src.LeetCode;

import java.util.*;

public class Leetcode515 {
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,1,list);
        return list;
    }

    public void dfs(TreeNode root, int level, List<Integer> list) {
          if (root == null) {
              return;
          }
          if (list.size() < level) {
              list.add(root.val);
          }else {
              list.set(level-1,Math.max(list.get(level-1),root.val));
          }
          dfs(root.left,level+1,list);
          dfs(root.right,level+1,list);
    }
}
