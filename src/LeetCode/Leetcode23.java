package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * @author hyy
 * @date 2019/9/6 16:59
 */
public class Leetcode23 {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    //优先队列的方法
    public ListNode mergeKListsByQueue(ListNode[] lists) {
        PriorityQueue<ListNode> treeSet = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode temp;
            while ((temp = lists[i])!=null){

                lists[i] = lists[i].next;
                treeSet.add(temp);
                temp.next = null;
            }
        }
        ListNode head = null;
        if (!treeSet.isEmpty()){
            head = treeSet.poll();
        }
        ListNode result = head;
        while (!treeSet.isEmpty()){
            head.next = treeSet.poll();
            head = head.next;
        }
        return result;
    }


    //遍历的方法
    public ListNode mergeKLists(ListNode[] lists) {

        int smallgest = 0;
        int secondsmall= 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[smallgest] == null) smallgest++;
        }
        if (smallgest == lists.length) return null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null&& lists[i].val < lists[smallgest].val){
                smallgest = i;
            }
        }

        ListNode head = lists[smallgest];
        ListNode result = head;
        lists[smallgest] = lists[smallgest].next;
        while (true){
            smallgest = 0;

            for (int i = 0; i < lists.length; i++) {
                if (lists[smallgest] == null) smallgest++;
            }
            if (smallgest == lists.length) break;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null&& lists[i].val < lists[smallgest].val){
                    smallgest = i;
                }
            }
            ListNode temp = lists[smallgest].next;
            head.next = lists[smallgest];
            head = head.next;
            lists[smallgest] = temp;

        }
        return result;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-2);
        ListNode l2 = new ListNode(-1);
        ListNode l3 = new ListNode(-1);
        ListNode l4 = new ListNode(-1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l5.next = l6;
        l7.next = l8;
        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = l1;
        Leetcode23 l = new Leetcode23();


        ListNode listNode = l.mergeKListsByQueue(listNodes);
        while (listNode != null)
        {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
