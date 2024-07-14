package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertFirst(7);
        list.display();
        list.deleteFirst();
        list.deleteLast();
        list.display();
    }
}
