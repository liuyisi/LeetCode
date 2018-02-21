/**
 * Created by liuyisi on 2018/2/20.
 */

public class DeleteNode {
    private class ListNode {
        int val;
        DeleteNode.ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 237.Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

     Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
     the linked list should become 1 -> 2 -> 4 after calling your function.
     * @param node
     */

    //time: O(1)
    public void deleteNode (ListNode node) {
        if (node == null || node.next == null)   return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
