package LinkedList;

class Node{
    int data;
    Node next;
    Node prev;

    Node(int val){
        this.data = val;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;

    DoublyLinkedList(){
        head = null;
    }

    void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    void insertionSort(){
        if(head == null || head.next == null){
            return;
        } else {
            Node sorted = null;
            Node current = head;
            while(current != null){
                Node next = current.next;
                sorted = sortedInsert(sorted, current);
                current = next;
            }
            head = sorted;
        }
    }

    Node sortedInsert(Node sorted, Node newNode){
        if(sorted == null){
            newNode.next = null;
            newNode.prev = null;
            return newNode;
        } else if (newNode.data <= sorted.data) {
            newNode.next = sorted;
            newNode.prev = null;
            sorted.prev = newNode;
            return newNode;
        } else {
            Node current = sorted;
            while(current.next != null && current.next.data < newNode.data){
                current = current.next;
            }
            newNode.next = current.next;
            if(current.next != null){
                current.next.prev = newNode;
            }
            newNode.prev = current;
            current.next = newNode;
            return sorted;
        }
    }

    void display(){
        Node current = head;
        Node tail = null;
        while(current != null){
            System.out.print(current.data + " <-> ");
            tail = current;
            current = current.next;
        }
        System.out.print("NULL");
        System.out.println();
        System.out.println("Reverse : ");
        while(tail != null){
            System.out.print(tail.data + " <-> ");
            tail = tail.prev;
        }
        System.out.print("NULL");
        System.out.println();
    }
}

public class SortDLL {
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(5);
        list.insert(2);
        list.insert(4);
        list.insert(1);
        list.insert(3);

        System.out.println("Original list : ");
        list.display();

        list.insertionSort();

        System.out.println("Sorted DLL : ");
        list.display();
    }
}