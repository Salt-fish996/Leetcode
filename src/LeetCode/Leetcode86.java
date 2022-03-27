package LeetCode;

public class Leetcode86 {
    public ListNode partition(ListNode head, int x) {
        // 通过 x 分割链表，那么使用两个链表，分别记录小于x的和大于x的结点
        ListNode ltHead = null;
        ListNode gteHead = null;
        ListNode lt = null;
        ListNode gte = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = null;
            if (head.val < x) {
                if (ltHead == null) {
                    ltHead = head;
                    lt = head;
                } else {
                    lt.next = head;
                    lt = lt.next;
                }
            } else {
                if (gteHead == null) {
                    gteHead = head;
                    gte = head;
                }else {
                    gte.next = head;
                    gte = gte.next;
                }
            }
            head = tmp;
        }

        if (lt != null) {
            lt.next = gteHead;
        } else {
            return gteHead;
        }
        return ltHead;
    }
}
