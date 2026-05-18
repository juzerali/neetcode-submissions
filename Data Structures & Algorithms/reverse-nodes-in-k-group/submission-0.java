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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        ListNode last = head;

        for(int i = 0; i < k-1; i++) {
            if(last == null) return head;
            last = last.next;
        }

        if(last == null) return head;
        ListNode next = last.next;

        last.next = null;
        head = reverse(head);

        last = head;
        while(last.next != null) last = last.next;
        last.next = reverseKGroup(next, k);

        return head;
    }

    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode tail = reverse(head.next);
        
        head.next.next = head;
        head.next = null;
        return tail;
    }
        
}
