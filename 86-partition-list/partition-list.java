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
        public ListNode partition(ListNode head, int x) {
            ListNode list1 = new ListNode(0);
            ListNode list2 = new ListNode(0);
            ListNode small = list1;
            ListNode large = list2;
        
            while(head != null){
                if(head.val < x){
                    small.next = head;
                    small = small.next;
                }
                else if(head.val >= x){
                    large.next = head;
                    large = large.next;
                }
                head = head.next;
            }
            large.next = null;
            small.next = list2.next;
            return list1.next;
            
        }
    }