package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode148 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode sortList1(ListNode head) {
          if (head == null || head.next == null) {
              return head;
          }

        ListNode newHead = null;
        ListNode newHeadIt = null;
        while (head != null) {
            ListNode n = head;
            ListNode pre = null;
            ListNode next = head.next;
            ListNode before = head;
            ListNode t = head.next;
            while (t != null) {
                if (t.val < n.val) {
                    n = t;
                    pre = before;
                    next = t.next;
                    before = t;
                    t = t.next;
                } else {
                    before = t;
                    t = t.next;
                }
            }
             if (pre != null){
                pre.next = next;
            } else {
                head = head.next;
            }
            if (newHead == null) {
                newHead = n;
                newHeadIt = n;
            } else {
                newHeadIt.next = n;
                newHeadIt = n;
            }
        }
        return newHead;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
               return o1.val - o2.val;
            }
        });
        while (head != null) {
            q.add(head);
            head = head.next;
        }
        head = q.poll();
        ListNode t = head;
        head.next = null;
        while (!q.isEmpty()) {
            t.next = q.poll();
            t = t.next;
            t.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        Leetcode148 l = new Leetcode148();

        ListNode l1 = new Leetcode148().new ListNode(4);
        ListNode l2 = new Leetcode148().new ListNode(2);
        ListNode l3 = new Leetcode148().new ListNode(1);
        ListNode l4 = new Leetcode148().new ListNode(3);
//        ListNode l5 = new Leetcode148().new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next=l4;
//        l4.next=l5;
        System.out.println(l.sortList(l1));
    }
}
