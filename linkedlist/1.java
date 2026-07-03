class Node
{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

function void even(Node head){
    Node temp = head;
    while(temp != null){
        if(temp.data % 2 == 0){
            System.out.print(temp.data + " ");
        }
        temp = temp.next;
    }
}



