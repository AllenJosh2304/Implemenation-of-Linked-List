public class DoublyLinkedList {
    Node head;
    Node tail;
    int size = 0;
    public void insertBegin(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail= node;
        }
        else{
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }
    public void append(int data){
        if(size == 0){
            insertBegin(data);
        } else {
            Node node = new Node(data);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
    public void deleteFirst(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("Succesfully deleted the forst element "+head.data);
        head = head.next;
        head.prev = null;
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
        System.out.println("Succesfully deleted the last element "+tail.data);
        temp.next = null;
        tail = temp;
        size--;
    }
    public void inserInBetween(int pos, int data) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 0) {
            insertBegin(data);
            return;
        }

        if (pos == size) {
            append(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        Node after = temp.next;
        Node node = new Node(data);

        temp.next = node;
        node.prev = temp;

        node.next = after;
        after.prev = node;

        size++;
    }

    public void deleteInBetween(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid Position");
            return;
        }
        if (pos == 0) {
            deleteFirst();
            return;
        }
        if (pos == size - 1) {
            deleteLast();
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }

        System.out.println("Successfully removed the element " + temp.data);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        size--;
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
    public void displayrev(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.prev;
        }
        System.out.println("End");
        System.out.println("Size -->"+ size);
    }

    private class Node{
        int data;
        Node next;
        Node prev;
        Node(int val){
            this.data = val;
        }

    }
}
