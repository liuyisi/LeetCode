/**
 * Created by liuyisi on 2018/2/18.
 */
public class LinkedListCycle2 {

    private class ListNode {
        int val;
        LinkedListCycle2.ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    //Reference: https://www.cnblogs.com/hiddenfox/p/3408931.html
    public ListNode detectCycle (ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
