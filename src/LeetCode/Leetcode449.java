package src.LeetCode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Leetcode449 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder res = new StringBuilder();
            res = this.dfs(root,res);
            return res.toString();
        }

        public StringBuilder dfs(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) {
                return stringBuilder;
            }
            stringBuilder = dfs(root.left,stringBuilder);
            stringBuilder = dfs(root.right,stringBuilder);
            stringBuilder.append(" ").append(root.val);
            return stringBuilder;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (Objects.equals(data, "")) {
                return null;
            }
            String[] ss = data.replaceFirst(" ","").split(" ");
            int[] arr = new int[ss.length];
            for (int i = 0; i < ss.length; i++) {
                arr[i] = Integer.parseInt(ss[i]);
            }
            return create(arr,0,arr.length);
        }

        public TreeNode create(int[] data, int start, int end) {
            if (start >= end) {
                return null;
            }
            // 根节点
            int v = data[end-1];
            TreeNode n = new TreeNode(v);
            if (start == end-1) {
                return n;
            }
            int begin = start;
            for (int i = start; i < end; i++) {
                if (data[i] < v) {
                    start++;
                } else {
                    break;
                }
            }
            n.left = create(data,begin,start);
            n.right = create(data,start,end-1);
            return n;
        }
    }
}
