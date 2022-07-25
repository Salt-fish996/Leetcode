package src.LeetCode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Leetcode919 {
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> q;
        TreeNode now;
        Set<TreeNode> s;
        public CBTInserter(TreeNode root) {
            this.root = root;
            this.q = new ArrayDeque<>();
            this.now = this.root;
            this.s = new HashSet<>();
            s.add(this.root);
        }

        public int insert(int val) {
            TreeNode n = new TreeNode(val);
            if (this.now.left != null && !s.contains(this.now.left)) {
                q.add(this.now.left);
                s.add(this.now.left);
            }
            if (this.now.right != null && !s.contains(this.now.right)) {
                q.add(this.now.right);
                s.add(this.now.right);
            }
            if (this.now.left == null) {
               this.now.left = n;
           } else if(this.now.right == null) {
                this.now.right = n;
           } else {
                this.now = q.poll();
                return this.insert(val);
            }
            q.add(n);
            return this.now.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }

    public static void main(String[] args) {
        Leetcode919 l = new Leetcode919();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        Leetcode919.CBTInserter t = new Leetcode919().new CBTInserter(t1);
        t.insert(3);
        t.insert(4);
        TreeNode res = t.get_root();
        System.out.println(res.val);
    }
}
