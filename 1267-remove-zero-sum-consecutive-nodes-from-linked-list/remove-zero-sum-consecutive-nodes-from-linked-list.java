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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        Map<Integer,ListNode>map = new HashMap<>();
        int preSum = 0;
        while(curr != null){
            preSum += curr.val;
            map.put(preSum,curr);
            curr = curr.next;
        }

        preSum = 0;
        curr = dummy;

        while(curr != null){
            preSum += curr.val;
            curr.next = map.get(preSum).next;
            curr = curr.next;
        }
        return dummy.next;
    }
}