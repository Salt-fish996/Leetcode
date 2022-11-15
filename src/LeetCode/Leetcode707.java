package src.LeetCode;

public class Leetcode707 {
    class MyLinkedList {
        class Node {
            int Val;
            Node next;

            public Node(int v) {
                this.Val = v;
            }
        }

        Node head;
        Node tail;
        int count = 0;
        public MyLinkedList() {
            head = null;
            tail = null;
            count = 0;
        }

        public int get(int index) {
            if (index > this.count || index < 0) {
                return -1;
            }
            Node r = this.head;
            int t = 0;
            while (r != null) {
                if (t == index) {
                    return r.Val;
                }
                t++;
                r = r.next;
            }
            return -1;
        }

        public void addAtHead(int val) {
            Node n = new Node(val);
            this.count++;
            if (this.head == null) {
                this.head = n;
                this.tail = n;
            }else {
                n.next = this.head;
                this.head = n;
            }
        }

        public void addAtTail(int val) {
            this.count++;
            Node n = new Node(val);
            if (head == null) {
                this.head = n;
            } else {
                this.tail.next = n;
            }
            this.tail = n;
        }

        public void addAtIndex(int index, int val) {
            if (index < 1) {
                this.addAtHead(val);
            } else if (index == count) {
                this.addAtTail(val);
            } else if (index < count) {
                int t = 0;
                this.count++;
                Node n = new Node(val);
                Node r = this.head;
                while (r != null) {
                    if (t == index-1) {
                        n.next = r.next;
                        r.next = n;
                        return;
                    }
                    t++;
                    r = r.next;
                }
            }
        }

        public void deleteAtIndex(int index) {
            if (index <0 || index > this.count) {
                return;
            }
            if (index == 0) {
                this.head = this.head.next;
                this.count--;
                return;
            }
            int t = 0;
            this.count--;
            Node r = this.head;
            while (r != null) {
                if (t == index-1) {
                    r.next = r.next.next;
                    return;
                }
                t++;
                r = r.next;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode707.MyLinkedList l = new Leetcode707().new MyLinkedList();
        l.addAtHead(1);
        l.addAtTail(3);
        l.addAtIndex(1,2);
        System.out.println(l.get(1));
        l.deleteAtIndex(0);
        System.out.println(l.get(0));
    }
}
