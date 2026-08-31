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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {-1, -1};
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        int first = -1;
        int last = -1;
        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;
        while(curr != null  && curr.next != null){
            if((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)){
                if(first == -1){
                    first = index;
                }
                else{
                    minDist = Math.min(minDist, index - last);
                    maxDist = index - first;
                }
                last = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        if(minDist == Integer.MAX_VALUE){
            return ans;
        }
        return new int[]{minDist, maxDist};
    }
}