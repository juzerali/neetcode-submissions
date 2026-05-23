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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode leftBound = findLeftBound(dummy, left);
        ListNode leftNode = leftBound.next;
        leftBound.next = reverseUntil(leftNode, right-left+1);
        leftNode.next = rem;
        return dummy.next;
    }

    ListNode rem;
    ListNode reverseUntil(ListNode head, int right) {
        if(right == 1) {
            rem = head.next;
            return head;
        }
        ListNode tail = reverseUntil(head.next, right-1);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    ListNode findLeftBound(ListNode head, int left) {
        if(left == 1) return head;
        return findLeftBound(head.next, left-1);
    }

    
}