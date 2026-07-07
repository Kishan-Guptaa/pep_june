// https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node reverseList(Node head) {
        // code here
        Node prev = null;
        Node temp= head;
        while(temp != null){
            Node tempp1 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempp1;
        }
        
        return prev;
       
    }
}