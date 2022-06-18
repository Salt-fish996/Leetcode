package src.LeetCode;

public class Leetcode109 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public TreeNode sortedListToBST(ListNode head) {
        // 计算有多少个结点
        ListNode now = head;
        int count = 0;
        while (now != null) {
            now = now.next;
            count++;
        }
        int[] arr = new int[count];
        int i = 0;
        now = head;
        while (now != null) {
            arr[i++] = now.val;
            now = now.next;
        }
        return sortedArrToBst(arr,1,arr.length);
    }

    public TreeNode sortedArrToBst(int[] arr,int begin,int end) {
         if (begin > end) {
             return null;
         }
         int mid = (begin+end) /2;
         TreeNode head = new TreeNode(arr[mid-1]);
         if (begin == end) {
             return head;
         }

         head.left = sortedArrToBst(arr,begin,mid-1);
         head.right = sortedArrToBst(arr,mid+1,end);
         return head;
    }

    public static void main(String[] args) {
        Leetcode109 l = new Leetcode109();
        Leetcode109.ListNode l1 = new Leetcode109().new ListNode(-10);
        Leetcode109.ListNode l2 = new Leetcode109().new ListNode(-3);
        Leetcode109.ListNode l3 = new Leetcode109().new ListNode(-0);
        Leetcode109.ListNode l4 = new Leetcode109().new ListNode(-5);
        Leetcode109.ListNode l5 = new Leetcode109().new ListNode(-9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Leetcode109.TreeNode res = l.sortedListToBST(l1);
        System.out.println(res);
    }
}
