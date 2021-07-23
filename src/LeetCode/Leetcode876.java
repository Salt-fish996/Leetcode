package LeetCode;

/**
 * @author hyy
 * @date 2020/3/23 8:46
 */
//通过
public class Leetcode876 {
    public ListNode middleNode(ListNode head) {

        //找到链表节点数
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }
        int mid = (count %2 == 0)?(count /2 + 1):(count +1)/2;
        temp = head;
        count = 0;
        while (count < mid) {
            temp = temp.next;
            count ++;
        }
        return temp;
    }
}
