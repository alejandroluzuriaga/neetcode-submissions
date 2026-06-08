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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        int indexes = 0;
        while (cur != null){
            nodes.add(cur);
            cur = cur.next;
            indexes++;
        }

        //get n-1 from last as a
        // a.next = n.next from last
        //return head
        int elemIndex = indexes-n;
        if (elemIndex < 0) // out of bounce
            return null;
        
        if (elemIndex -1 < 0){ //first
            return head.next;
        }

        //not first - has a previous
        ListNode elem = nodes.get(indexes-n);
        ListNode prev = nodes.get(elemIndex-1);

        if (elem.next == null)
            prev.next = null;
        else
            prev.next = elem.next;

        return head;
    }
}
