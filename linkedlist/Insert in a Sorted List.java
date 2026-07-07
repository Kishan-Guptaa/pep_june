// https://www.geeksforgeeks.org/problems/insert-in-a-sorted-list/1

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
        // Add your code here.
        Node newNode = new Node(key);
        if(head == null || head.data > key){
            newNode.next = head;
            return newNode;
        }
        
        Node temp = head;
        while(temp.next != null && temp.next.data < key){
            temp = temp.next;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
}