/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;

        head.next = reverse(head.next);
        reorderList(head.next);
    }

    ListNode reverse(ListNode head) {
        if(head == null) return null;

        if(head.next == null) return head;

        ListNode tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
