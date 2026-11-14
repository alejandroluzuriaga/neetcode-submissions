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
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
            
        ListNode faster = head.next == null ? null : head.next;
        while (head.next != null && faster != null){
            if (faster == head)
                return true;
            
            if (faster.next == null)
                return false;

            faster = faster.next.next;
            head = head.next;
        }
        return false;
    }
}
