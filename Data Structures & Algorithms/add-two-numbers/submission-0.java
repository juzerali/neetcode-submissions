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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        add(head, l1, l2, 0);
        return head;
    }

    private void add(ListNode head, ListNode l1, ListNode l2, int carry) {
        if(head == null) return;
        
        if(l1 == null && l2 == null) {
            if(carry > 0) {
                head.val = 1;
                return;
            }
        }

        if(l1 == null) l1 = new ListNode(0);
        if(l2 == null) l2 = new ListNode(0);

        head.val = carry + l1.val + l2.val;
        carry = head.val / 10;
        head.val = head.val % 10;

        if(l1.next != null || l2.next != null || carry > 0) head.next = new ListNode(0);

        add(head.next, l1.next, l2.next, carry);
    }
}
