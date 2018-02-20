/**
 * Created by liuyisi on 2018/2/18.
 */
public class ReorderList {
    private class ListNode {
        int val;
        ReorderList.ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    /**
        Given a singly linked list L: L0→L1→…→Ln-1→Ln,
        reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

        You must do this in-place without altering the nodes' values.

        For example,
        Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */
    public void reorderList (ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = partition(head);
        ListNode l2 = mid.next;
        //de-link the second half from the former one, or the first part will stuck in dead loop
        mid.next = null;
        ListNode l1 = head;
        l2 = reverse(l2);
        merge(l1, l2);
    }

    private ListNode partition (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode merge (ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int count = 1;
        while (l1 != null && l2 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur.next.next = l2;
            l2 = l2.next;
            cur = cur.next.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }else {
            cur.next = l2;
        }
        return dummy.next;
    }
}
