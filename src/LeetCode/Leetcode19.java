package src.LeetCode;

/**
 * @author hyy
 * @date 2019/8/4 21:21
 */
public class Leetcode19 {
    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick = null;
        ListNode slow = null;
        if (head.next == null){
            if (n == 1)
                return null;
        }
        while (n!=0){
            if (quick == null)
                quick = head;
            else
            quick = quick.next;
            n--;
        }
        while (quick.next !=null){
            if (slow == null)
                slow = head;
            else slow = slow.next;
            quick = quick.next;
        }
        if (slow == null){
            return head.next;

        }
        ListNode temp = slow.next.next;
        slow.next = temp;
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ln1 = new ListNode(2);
        ListNode ln2 = new ListNode(3);
        ListNode ln3 = new ListNode(4);
        ListNode ln4 = new ListNode(5);
        head.next = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        Leetcode19 leetcode19 = new Leetcode19();
        leetcode19.removeNthFromEnd(head,2);

    }
}
