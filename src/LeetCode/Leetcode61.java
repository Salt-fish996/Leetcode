package src.LeetCode;

//旋转链表，通过
public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {

        //首先统计链表有多长
        ListNode tempNode = head;
        ListNode preNode = null;
        int n = 0;
        while (tempNode!=null){
            n++;
            preNode = tempNode;
            tempNode = tempNode.next;
        }

        //如果结点数目为0或者是k的因子，那么直接返回节点
        if (n == 0 || k % n == 0){
            return head;
        }else {
            k = k % n;//实际要移动的结点
            int m = n - k - 1;
            ListNode temp = head;
            while (m >0){
                m--;
                temp = temp.next;
            }

            tempNode = temp.next;
            temp.next = null;
            preNode.next = head;
            return tempNode;
        }
    }
}
