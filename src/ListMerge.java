public class ListMerge {
    public static class ListNode {
        int value;
        ListNode next;
    }
    public ListNode merge(ListNode l1,ListNode l2) {
        ListNode res = null;
        ListNode now = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.value < l2.value) {
            res = l1;
            l1 = l1.next;
            now = res;
        } else {
            res = l2;
            l2 = l2.next;
            now = res;
        }
        while (true) {
            if (l1 == null) {
                now.next = l2;
                return res;
            }
            if (l2 == null) {
                now.next = l1;
                return res;
            }
            if (l1.value < l2.value) {
                now.next = l1;
                l1 = l1.next;
                now = now.next;
            } else {
                now.next = l2;
                l2 = l2.next;
                now = now.next;
            }
        }
    }
}
