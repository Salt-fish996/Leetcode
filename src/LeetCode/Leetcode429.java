package src.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        // n 叉树的层序遍历
        Queue<Node> q = new LinkedList<>(); // 存储结点
        Queue<Integer> level = new LinkedList<>(); // 存储层数
        List<List<Integer>> res = new ArrayList<>();
        q.add(root);
        level.add(0);
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n == null) {
                continue;
            }
            int l = level.poll();
            if (res.size() <= l) {
                res.add(new ArrayList<>());
            }
            List<Integer> t = res.get(l);
            t.add(n.val);
            for (int i = 0; i < n.children.size(); i++) {
                q.add(n.children.get(i));
                level.add(l+1);
            }
        }
        return res;
    }
}
