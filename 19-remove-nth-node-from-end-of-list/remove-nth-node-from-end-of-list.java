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
    private ListNode reverse(ListNode head){
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode tempp1 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempp1;
        }
        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);
        if(n == 1){
            head = head.next;
            return reverse(head);
        }
        ListNode temp = head;
        for(int i=1; i<n-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        head = reverse(head);

        return head;
    }
}