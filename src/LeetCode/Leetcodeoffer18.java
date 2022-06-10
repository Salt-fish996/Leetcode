package src.LeetCode;

public class Leetcodeoffer18 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode n = head.next;
        while (n != null) {
            if (n.val == val) {
                pre.next = n.next;
                return head;
            }
            pre = n;
            n = n.next;
        }
        return head;
    }
}
