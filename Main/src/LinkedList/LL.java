package LinkedList;

public class LL{

    private Node head;
    
    public LL(){
        
    }

    public int getSize(){

        if(head == null){
            return 0;
        }

        int len = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }

    public void insertFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void insert(int val , int index){
        int size = this.getSize();

        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }

        Node newNode = new Node(val, temp.next);
        temp.next = newNode;

    }

    public void insertLast(int val){
        if(head == null){
            Node node = new Node(val);
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
    }

    public void deleteFirst(){
        head = head.next;
    }

    public void deleteLast(){
        if(head == null){
            return;
        }

        if(head.next == null){
            head = head.next;
            return;
        }

        Node temp = head;

        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = temp.next.next;

    }

    public void delete(int index){

        int size = getSize();

        if(index == 0){
            deleteFirst();
            return;
        }

        if(index == size){
            deleteLast();
            return;
        }

        Node temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }

        
        temp.next = temp.next.next;

    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    private class Node{
        int val;
        Node next;

        public Node(){}

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        
    }
}