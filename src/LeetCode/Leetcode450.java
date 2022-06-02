package src.LeetCode;

public class Leetcode450 {
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

    public TreeNode deleteNode(TreeNode root, int key) {
          if (root == null) {
              return null;
          }
          if (root.val == key) {
              if (root.left == null) {
                  return root.right;
              }
              TreeNode n = root.left;
              while (n.right != null) {
                  n = n.right;
              }
              n.right = root.right;
              return n;
          }
        if (dfs(root.left,root,key,true)) {
            return root;
        }
        dfs(root.right,root,key,false);
        return root;
    }

    public boolean dfs(TreeNode node,TreeNode parent,int key,boolean isLeftChild) {
          if (node == null) {
              return false;
          }
          if (node.val == key) {
              if (node.left != null) {
                  if (isLeftChild) {
                      parent.left = node.left;
                  } else {
                      parent.right = node.left;
                  }
                  TreeNode n = node.left;
                  while (n.right != null) {
                      n = n.right;
                  }
                  n.right = node.right;
              } else {
                  if (isLeftChild) {
                      parent.left = node.right;
                  } else {
                      parent.right = node.right;
                  }
              }
              return true;
          }
          if (dfs(node.left,node,key,true)){
              return true;
          };
          return dfs(node.right,node,key,false);
    }

    public static void main(String[] args) {
        Leetcode450 l = new Leetcode450();
        Leetcode450.TreeNode t1 = new Leetcode450().new TreeNode(5);
        Leetcode450.TreeNode t2 = new Leetcode450().new TreeNode(3);
        Leetcode450.TreeNode t3 = new Leetcode450().new TreeNode(2);
        Leetcode450.TreeNode t4 = new Leetcode450().new TreeNode(4);
        Leetcode450.TreeNode t5 = new Leetcode450().new TreeNode(6);
        Leetcode450.TreeNode t6 = new Leetcode450().new TreeNode(7);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;
        System.out.println(l.deleteNode(t1,7));
    }
}
