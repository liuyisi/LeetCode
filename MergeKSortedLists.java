import java.util.*;
public class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
}

/**
 * Created by liuyisi on 2018/2/17.
 */
public class MergeKSortedLists {
    public ListNode mergeLists (ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    private ListNode sort (ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        }
        int mid = low + (high - low) / 2;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);
        return merge(l1, l2);
    }

    private ListNode merge (ListNode l1, ListNode l2) {
        ListNode l0 = new ListNode(0);
        ListNode dummy = new ListNode(0);
        dummy = l0;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l0.next = l1;
                l1 = l1.next;
                l0 = l0.next;
            }else {
                l0.next = l2;
                l2 = l2.next;
                l0 = l0.next;
            }
        }
        if (l1 == null) {
            l0.next = l2;
        }else {
            l0.next = l1;
        }
        return dummy.next;
    }
}
