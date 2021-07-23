package LeetCode;


//分割链表，通过
public class Leetcode725 {
    public ListNode[] splitListToParts(ListNode root, int k) {

        //统计结点数
        int n = 0;
        ListNode listNode1 = root;
        while (listNode1!= null){
            n++;
            listNode1 = listNode1.next;
        }
        ListNode[] listNodes = new ListNode[k];
        //计算每个划分需要的最少节点数
        int m = n / k;
        //计算需要多少个包含m+1的结点的划分
        int count = n % k;
        ListNode listNode = root;
        ListNode preNode = null;
        for (int i = 0; i < k; i++) {
            listNodes[i] = listNode;//放入结点
            int h = 0;
            if (count > 0){
                h = m + 1;
                count--;
            }else {
                h = m;
            }
            while (h > 0){
                preNode = listNode;
                listNode = listNode.next;
                h--;
            }
            if (preNode != null){
                preNode.next = null;
            }

        }
        return listNodes;
    }
}
