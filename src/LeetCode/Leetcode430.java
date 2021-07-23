package LeetCode;

public class Leetcode430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    public Node endNode(Node head){//返回尾结点
        Node end = null;
        Node last = null;
        while (head!=null){
            if (head.child !=null){
                if (head.next!=null){
                    Node temp = head.next;
                    head.next = head.child;
                    head.child.prev = head;
                    Node t2 = head;
                    end = endNode(head.child);
                    t2.child = null;
                    end.next = temp;
                    temp.prev = end;
                    last = end;
                    head = temp;
                }else {

                    head.next = head.child;
                    head.child.prev = head;
                    Node t2 = head;
                    end = endNode(head.child);
                    t2.child = null;
                    end.next = null;
                    return end;

                }

            }else {
                last = head;
                head = head.next;
            }
        }
        return last;
    }
    public Node flatten(Node head) {

        if (head == null) return null;
        endNode(head);
        return head;
    }

}
