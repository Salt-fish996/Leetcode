package LeetCode;

/**
 * @author hyy
 * @date 2019/8/15 20:37
 */
public class Leetcode24 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *  
     *
     * 示例:
     *
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public ListNode swapPairs(ListNode head) {
        if (head.next == null) return head;

        ListNode first = null;
        ListNode second = null;
        ListNode headresult  = null;
        int count = 1;
        ListNode last = null;



        while (head != null && head.next != null){

            first = head;
            second = head.next;
            head = head.next.next;
            if (count-- == 1){
                headresult = second;
            }
            second.next = first;
            if (last != null){
                last.next = second;
            }
            last = first;
            last.next = null;

        }
        if (head != null && last !=null) last.next = head;

        return headresult;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        Leetcode24 l = new Leetcode24();
        l.swapPairs(l4);
    }
}
