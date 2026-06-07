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
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode newList = new ListNode(0);
        ListNode current = newList;
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        while(h1 != null && h2 != null){    
            if (h1.val <= h2.val){
                current.next = h1;
                h1 = h1.next;
            }
            else{
                current.next = h2;
                h2 = h2.next;
            }
            current = current.next;
        }
        current.next = (h1 == null) ? h2 : h1;

        return newList.next;
    }
}