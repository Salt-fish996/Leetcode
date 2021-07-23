package LeetCode;

public class Leetcode328 {
    //奇偶链表,通过
    //使用一个变量来指向当前的奇数链表
    //使用一个变量来指向当前的偶数链表
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode jiShuHead = null;//奇数序号头
        ListNode ouShuHead = null;//偶数序号头
        ListNode jiShuTail = null;//奇数序号尾
        ListNode ouShuTail = null;//偶数序号尾

        boolean flag = true;//由来表示当前遍历到的是奇数序号结点还是偶数，奇数为true

        ListNode temp = head;
        while (temp != null){
            if (flag){//如果是奇数序号结点
                if (jiShuHead == null){
                    jiShuHead = temp;
                    temp = temp.next;
                    jiShuTail = jiShuHead;
                }else {
                    jiShuTail.next = temp;
                    jiShuTail = temp;
                    temp = temp.next;
                }
                flag = false;
            }else {
                if (ouShuHead == null){
                    ouShuHead = temp;
                    temp = temp.next;
                    ouShuTail = ouShuHead;
                }else {
                    ouShuTail.next = temp;
                    ouShuTail = temp;
                    temp = temp.next;
                }
                flag = true;
            }
        }
        assert jiShuTail != null;
        jiShuTail.next = ouShuHead;
        assert ouShuTail != null;
        ouShuTail.next = null;

        return jiShuHead;
    }
}
