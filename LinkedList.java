public class LinkedList {

    private Node head;
    private Node tail;
    private int size;
    LinkedList() {
        this.size = 0;
    }

    public void insertFirst(int data){
             Node node = new Node(data);
             node.next = head;
             head = node;

             if(tail == null){
                 tail = head;
             }
             size+=1;
    }

    public void append(int data){
        if(size == 0){
            insertFirst(data);
        } else {
            Node node = new Node(data);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void inserInBetween(int pos,int data){
        if(pos == 0){
            insertFirst(data);
            return;
        }
        if(pos==size){
            append(data);
            return;
        }
        if(pos<size){
            Node temp = head;
            for(int i =1;i<size;i++){
                if(i == pos-1){
                    Node after = temp.next;
                    Node node = new Node(data);
                     temp.next = node;
                     node.next = after;
                     break;
                }
                temp = temp.next;
            }
            size+=1;
        }
        else
            System.out.println("Invalid position no.");
    }
    public void deleteFirst(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Succesfully deleted the forst element "+head.data);
        head = head.next;
        size--;
        if (head == null) { 
            tail = null;
        }

    }
    public void deleteLast(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        System.out.println("Succesfully deleted the last element "+temp.data);
        temp.next = null;
        tail = temp;
        size--;

    }
    public void deleteInBetween(int pos){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }
        if(pos>size){
            System.out.println("Invalid Position");
            return;
        }
        Node temp = head;
        for(int i = 1;i<pos;i++){
            temp = temp.next;
        }
        Node node = temp.next;
        temp.next = node.next;
        System.out.println("Succesfully removed the element " + node.data );

    }


    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("End");
        System.out.println("Size -->"+ size);
    }

   public void reverse(){
        Node prev = null;
        Node current  = head;
        Node next = head.next;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current  =next;
        }
        head = prev;
   }

    private class Node{

         private int data;
         private Node next;
         
            Node(int data){
                this.data = data;
            }
    }

}
