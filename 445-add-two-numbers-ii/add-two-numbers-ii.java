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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer>st1 = new Stack<>();
        Stack<Integer>st2 = new Stack<>();
        ListNode temp = l1;
        while(temp != null){
            st1.push(temp.val);
            temp = temp.next;
        }
        ListNode temp2 = l2;
        while(temp2 != null){
            st2.push(temp2.val);
            temp2 = temp2.next;
        }
        int carry = 0;
        ListNode head = null;

        while(!st1.isEmpty() || !st2.isEmpty() || carry != 0){
            int sum = carry;
             if (!st1.isEmpty()) {
                sum += st1.pop();
            }

            if (!st2.isEmpty()) {
                sum += st2.pop();
            }

            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }

        return head;

    }
}