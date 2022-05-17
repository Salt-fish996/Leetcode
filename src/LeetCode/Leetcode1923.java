package src.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 未通过，youbug
public class Leetcode1923 {
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
  TreeNode res = null;
      int count = 0;
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Map<Integer,Integer> situation = new HashMap<>();
        int[] status = new int[trees.size()];
        for (int i = 0; i < trees.size(); i++) {
            TreeNode n = trees.get(i);
            situation.put(n.val,i);
            map.put(n.val,n);
        }
        for (int i = 0; i < trees.size(); i++) {
            if (status[i] == 0) {
                dfs(trees,status,trees.get(i),map,situation);
            }
        }
        int count = 0;
        TreeNode root = null;
        for (int i = 0; i < trees.size(); i++) {
            if (trees.get(i) != null) {
                count++;
                root = trees.get(i);
            }
        }
        if (count > 1) {
            return null;
        }
        if (check(root,true) != -1) {
            return root;
        }
        return null;
    }

    public void dfs(List<TreeNode> trees,int[] status,TreeNode root,Map<Integer,TreeNode> map,Map<Integer,Integer> situation){
          if (root.left != null && map.containsKey(root.left.val) && trees.get(situation.get(root.left.val)) !=null) {
              root.left = map.get(root.left.val);
              trees.set(situation.get(root.left.val),null);
              status[situation.get(root.left.val)] = 1;
              dfs(trees,status,root.left,map,situation);
          }
          if (root.right != null && map.containsKey(root.right.val) && trees.get(situation.get(root.right.val)) !=null) {
              root.right = map.get(root.right.val);
              trees.set(situation.get(root.right.val),null);
              status[situation.get(root.right.val)] = 1;
              dfs(trees,status,root.right,map,situation);
          }
    }

    public int check(TreeNode root,boolean isRight) {
        int min = 0;
        int max=0;
        if (root.left != null) {
            max = check(root.left,false);
            if (max == -1) {
                return max;
            }
            if (max >= root.val) {
                return -1;
            }
        }
        if (root.right != null) {
            min = check(root.right,true);
            if (min == -1) {
                return -1;
            }
            if (root.val >= min) {
                return -1;
            }
        }
        if (isRight) {
            return max==0?root.val:max;
        }
        return min==0?root.val:min;
    }

    public static void main(String[] args) {
        Leetcode1923 l = new Leetcode1923();
        TreeNode t1 = new Leetcode1923().new TreeNode(2);
        TreeNode t2 = new Leetcode1923().new TreeNode(1);
        TreeNode t3 = new Leetcode1923().new TreeNode(3);
        TreeNode t4 = new Leetcode1923().new TreeNode(3);
        TreeNode t5 = new Leetcode1923().new TreeNode(2);
//        TreeNode t6 = new Leetcode1923().new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t4.left = t5;
//        t4.right = t6;
        List<TreeNode> list = new ArrayList<>();
        list.add(t1);
        list.add(t4);

        System.out.println(l.canMerge(list));
    }
}
