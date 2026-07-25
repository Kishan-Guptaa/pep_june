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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int groupSize = 1;
        while(curr != null){
            int count = 0;
            ListNode temp = curr;
            while(temp != null && count < groupSize){
                temp = temp.next;
                count++;
            }

            if(count % 2 == 0){
                ListNode groupPrev = prev;
                ListNode groupStart = curr;
                ListNode next = temp;
                ListNode p = curr;
                ListNode prevNode = next;
                for(int i=0; i<count; i++){
                    ListNode nxt = p.next;
                    p.next = prevNode;
                    prevNode = p;
                    p = nxt;
                }

                groupPrev.next = prevNode;
                prev = groupStart;
                curr = next;
            }
            else{
                for(int i=0; i<count; i++){
                    prev = curr;
                    curr = curr.next;
                }
            }
            groupSize++;
        }

        return dummy.next;
    }
}