package src.LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hyy
 * @date 2019/9/8 21:16
 */
public class Leetcode143 {
    public void reorderList(ListNode head) {

        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();
        //首先遍历一遍链表，把结点放入栈中
        ListNode temp = head;
        int count = 0;//用于统计总共有多少结点
        while (temp!=null){
            stack.push(temp);
            queue.add(temp);
            ListNode t = temp;
            temp = temp.next;
            t.next = null;
            count++;
        }
        ListNode newHead = queue.poll();
        int hadPut = 0;
        count--;
        while (hadPut!=(count)/2){
            newHead.next = stack.pop();
            newHead.next.next = queue.poll();
            newHead = newHead.next.next;
            hadPut++;
        }
        if (count%2 == 1) newHead.next = stack.pop();
        return;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l7.next = l8;
        Leetcode143 l = new Leetcode143();
        l.reorderList(l1);
    }
}
