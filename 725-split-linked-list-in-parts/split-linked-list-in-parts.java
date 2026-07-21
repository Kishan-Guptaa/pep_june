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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int n = 0;
        ListNode curr = head;
        while(curr != null){
            n++;
            curr = curr.next;
        }
        int base = n / k;
        int extra = n % k;

        curr = head;
        for(int i=0; i<k; i++){
            if(curr == null){
                ans[i] = null;
                continue;
            }
            ans[i] = curr;

            int partSize = base + (extra > 0 ? 1 : 0);
            if(extra > 0){
                extra--;
            }

            for(int j=1; j<partSize; j++){
                curr = curr.next;
            }
            ListNode next = curr.next; 
            curr.next = null;
            curr = next;
        }
        return ans;

    }
}