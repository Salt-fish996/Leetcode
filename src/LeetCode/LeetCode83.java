package src.LeetCode;

public class LeetCode83 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
      public ListNode deleteDuplicates(ListNode head) {
            // preNode 记录当前结点的前一个结点， nowNode 记录当前结点，
            ListNode preNode = head;
            if (head == null ) {
                return head;
            }
            ListNode nowNode = head.next;
            while (nowNode != null) {
               // 如果当前结点和上一个结点的值相同，那么去掉当前结点
               if (nowNode.val == preNode.val) {
                   preNode.next = nowNode.next;
                   nowNode = preNode.next;
               } else {
                   preNode = nowNode;
                   nowNode = nowNode.next;
               }
            }
            return head;
      }
}
