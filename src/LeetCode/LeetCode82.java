package src.LeetCode;

public class LeetCode82 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {

        // preNode 记录当前结点前的结点，nowNode 记录当前结点, duNode 记录重复开始的结点， duPreNode 记录重复开始前的结点
        ListNode preNode = head;
        ListNode duNode = head;
        ListNode duPreNode = head;
        if (head == null) {
            return head;
        }
        ListNode nowNode = head.next;
        while (nowNode != null) {
            if (nowNode.val == duNode.val) {
                preNode = nowNode;
                nowNode = nowNode.next;
            } else {
                // 当前结点已经不是重复的结点了，那么就要进行处理
                // 如果是从头结点就开始重复了，那么要把head重新赋值
                if (duPreNode == head && preNode != head) {
                    head = nowNode;
                    duPreNode = nowNode;
                    preNode = nowNode;
                } else {
                    if (duPreNode == preNode) {
                        duPreNode = nowNode;
                        preNode = nowNode;
                    }
                   duPreNode.next = nowNode;
                   nowNode = nowNode.next;
                }
                preNode = nowNode;
                nowNode = nowNode.next;


            }
        }
        return null;
    }
}
