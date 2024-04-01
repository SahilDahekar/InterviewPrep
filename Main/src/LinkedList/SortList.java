package LinkedList;

class Node{
    int data;
    Node next;

    public Node(){
        this.data = 0;
        this.next = null;
    }

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LL {
    Node head;

    LL(){
        head = null;
    }

    Node getHead(){
        return head;
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

    Node sortList(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return merge(left,right);
    }

    Node merge(Node l1, Node l2){
        Node dummy = new Node(0);
        Node tail = dummy;

        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        head = dummy.next;
        return dummy.next;  
    }

    Node getMid(Node head){
        Node midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    Node sortedInsert(Node sorted, Node newNode){
        if(sorted == null){
            newNode.next = null;
            return newNode;
        } else if(newNode.data <= sorted.data){
            newNode.next = sorted;
            return newNode;
        } else {
            Node current = sorted;
            while(current.next != null && current.next.data < newNode.data){
                current = current.next;
            }
            if(current.next != null){
                newNode.next = current.next;
            }
            current.next = newNode;
            return sorted;
        }
    }

    void display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}

public class SortList {
    public static void main(String[] args){
        LL list = new LL();
        list.insert(5);
        list.insert(2);
        list.insert(4);
        list.insert(1);
        list.insert(3);

        System.out.println("Original list : ");
        list.display();

        list.sortList(list.getHead());
        // list.insertionSort();

        System.out.println("Sorted LL : ");
        list.display();
    }
}
