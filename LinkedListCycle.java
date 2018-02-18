import java.util.*;
/**
 * Created by liuyisi on 2018/2/18.
 */
public class LinkedListCycle {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public boolean hasCycle (ListNode head) {
        if (head == null || head.next == null)  return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
