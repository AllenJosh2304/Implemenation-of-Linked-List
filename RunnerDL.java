public class RunnerDL {
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.insertBegin(5);
        dl.insertBegin(4);
        dl.append(6);
        dl.append(7);
        dl.inserInBetween(3,9);
        dl.deleteInBetween(3);
        //dl.deleteFirst();
        dl.display();
        //dl.displayrev();
    }
}
