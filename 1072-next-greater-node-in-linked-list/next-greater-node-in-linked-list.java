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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer>list = new ArrayList<>();
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int n = list.size();
        int[] ans = new int[n];
        Stack<Integer>st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && list.get(i) > list.get(st.peek())){
                int idx = st.pop();
                ans[idx] = list.get(i);
            }
            st.push(i);
        }
        return ans;
       
    }
}