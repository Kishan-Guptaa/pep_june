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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer>st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }

        ListNode temp = head;
        int count = 0;
        while(temp != null){
            if(st.contains(temp.val) && (temp.next == null || !st.contains(temp.next.val))){
                count++;
            }
            temp = temp.next;
        }
        return count;
    }
}