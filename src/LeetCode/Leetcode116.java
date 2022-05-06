package src.LeetCode;

import java.util.*;

public class Leetcode116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }
        if (root.left == null) {
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        q.add(root);
        level.add(1);
        while (!q.isEmpty()) {
            Node n = q.poll();
            int l = level.poll();
            List<Node> list = map.getOrDefault(l,new ArrayList<>());
            list.add(n);
            map.put(l,list);
            if (n.left != null) {
                q.add(n.left);
                level.add(l+1);
            }
            if (n.right != null) {
                q.add(n.right);
                level.add(l+1);
            }
        }

        for(Map.Entry<Integer,List<Node>> entry: map.entrySet()) {
            List<Node> l = entry.getValue();
            for (int i = 1; i < l.size(); i++) {
                l.get(i-1).next = l.get(i);
            }
        }

        return root;
    }

}
