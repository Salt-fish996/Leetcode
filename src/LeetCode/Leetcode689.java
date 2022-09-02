package src.LeetCode;

public class Leetcode689 {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int s = dfs(root,root.val);
        return Math.max(this.res,s);
    }

    public int dfs(TreeNode root, int parentValue) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        this.res = Math.max(this.res,left+right+1);
        if (root.val == parentValue) {
            return Math.max(left,right)+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode689 l = new Leetcode689();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(5);
        t4.left = t3;
        t3.left = t1;
        t3.right = t2;
        t4.right = t5;
        t5.right = t6;
        System.out.println(l.longestUnivaluePath(t4));
    }
}
