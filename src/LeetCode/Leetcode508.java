package src.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode508 {
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
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        this.max = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        dfs(root,map);
        List<Integer> l = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry: map.entrySet()
             ) {
            if (entry.getValue() == this.max) {
                l.add(entry.getKey());
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }

    public int dfs(TreeNode root, Map<Integer,Integer> map) {
        if (root == null) {
            return 0;
        }
        int nowSum = dfs(root.left,map) + dfs(root.right,map)+root.val;
        int v = map.getOrDefault(nowSum,0)+1;
        map.put(nowSum,v);
        this.max = Math.max(this.max,v);
        return nowSum;
    }
}
