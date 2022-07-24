package src.LeetCode;

/**
 * @author hyy
 * @date 2019/8/15 20:58
 */
public class Leetcode25 {
    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 示例 :
     *
     * 给定这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 说明 :
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

//通过
    public ListNode reversePart(ListNode head, ListNode tail){
        //进行部分的翻转,返回反转后的尾结点
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode next = head.next;
        ListNode temp = head.next.next;
        ListNode listNode = tail.next;
        while (next !=  listNode&& next != null){
            next.next = pre;
            pre = next;
            next = temp;
            if (next != null){
                temp = next.next;
            }
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1)return head;
        //记录待翻转头结点
        ListNode reverseNodeHead = head;
        //记录待翻转尾结点
        ListNode reverseNodeTail = head;
        //记录尾结点下一个结点
        ListNode next = null;
        //记录上一部分的尾结点
        ListNode lastPartTail = null;

        ListNode result = head;

        ListNode temp = head;
        int count = 0;
        while (temp!=null){
             count = k - 1;
            while (count>0){
                if (reverseNodeTail!= null && reverseNodeTail.next != null){
                    reverseNodeTail = reverseNodeTail.next;
                    temp = temp.next;
                }else {
                    break;
                }
                count--;
            }
            temp = temp.next;

            //reverseNodeTail已经到了要转换的点
            if (count == 0){//如果满足K个结点
                if (result == head){//保存要返回的头结点
                    result = reverseNodeTail;
                }
                ListNode listNode1 = reverseNodeTail.next;
                if (lastPartTail != null){
                    lastPartTail.next = reverseNodeTail;
                }
                ListNode listNode = reversePart(reverseNodeHead,reverseNodeTail);
                lastPartTail = listNode;
                listNode.next = listNode1;
                reverseNodeHead = listNode1;
                reverseNodeTail = reverseNodeHead;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        Leetcode25 l = new Leetcode25();

        ListNode node = l.reverseKGroup(l1,1);
        while (node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}
