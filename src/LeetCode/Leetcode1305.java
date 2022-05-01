package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1305 {
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1,l1);
        dfs(root2,l2);
        int index1= 0;
        int index2 = 0;
        while (index1 < l1.size() || index2 < l2.size()) {
            if (index1 < l1.size() && index2 < l2.size()) {
                if (l1.get(index1) < l2.get(index2)) {
                    res.add(l1.get(index1++));
                } else {
                    res.add(l2.get(index2++));
                }
            } else if (index1 < l1.size()) {
                res.addAll(l1.subList(index1,l1.size()));
                break;
            } else {
                res.addAll(l2.subList(index2,l2.size()));
                break;
            }
        }
        return res;
    }

    public void dfs(TreeNode r, List<Integer> l) {
          if (r == null) {
              return;
          }
          dfs(r.left,l);
          l.add(r.val);
          dfs(r.right,l);
    }


}
