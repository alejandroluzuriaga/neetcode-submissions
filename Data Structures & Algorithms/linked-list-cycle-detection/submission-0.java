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
        // i believe this has two pointers, one advancing faster
        if (head == null)
            return false;
            
        Map<ListNode, Integer> m = new HashMap<>(); // elem -> aparitions
        ListNode current = head;
        while (current != null){
            if (!m.containsKey(current))
                m.put(current, 1);
            else
                return true;
            current = current.next;
        }

        return false;
    }
}
