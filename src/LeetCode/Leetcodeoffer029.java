package src.LeetCode;

public class Leetcodeoffer029 {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        Node res = head;
        Node n = new Node(insertVal);
        // 没有结点
        if (head == null) {
            // 没有结点，创建一个节点
             n.next = n;
             return n;
        }
        Node minNode = res;
        Node maxNode = res;


        // 遍历找点
        while (true) {

            if (insertVal >= head.val) {
                if (head.next.val >= insertVal || head.next.val < head.val) {
                    // 插入节点
                    n.next = head.next;
                    head.next = n;
                    return res;
                }
            }
            // 只有一个节点，或者已经遍历了一遍了
            if (head.next == res) {
                if (minNode == maxNode) {
                    head.next = n;
                    n.next = res;
                }else {
                    n.next = minNode;
                    maxNode.next = n;
                }
                return res;
            }
            head = head.next;
            if (minNode.val > head.val) {
                minNode = head;
            }
            if (maxNode.val < head.val) {
                maxNode = head;
            }
        }
    }
}
