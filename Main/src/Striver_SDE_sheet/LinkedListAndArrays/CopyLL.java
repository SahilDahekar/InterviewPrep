package LinkedListAndArrays;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }
}

public class CopyLL {

    // Hash Method
    // public Node copyRandomList(Node head) {
    //     if (head == null) return null;
        
    //     HashMap<Node, Node> oldToNew = new HashMap<>();
        
    //     Node curr = head;
    //     while (curr != null) {
    //         oldToNew.put(curr, new Node(curr.val));
    //         curr = curr.next;
    //     }
        
    //     curr = head;
    //     while (curr != null) {
    //         oldToNew.get(curr).next = oldToNew.get(curr.next);
    //         oldToNew.get(curr).random = oldToNew.get(curr.random);
    //         curr = curr.next;
    //     }
        
    //     return oldToNew.get(head);
    // }

    // Interweiving method requires no extra space
    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val, curr.next);
            curr.next = newNode;
            curr = newNode.next;
        }

        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next != null ? curr.next.next : null;
        }

        Node old_head = head;
        Node new_head = head.next;
        Node curr_old = old_head;
        Node curr_new = new_head;

        while(curr_old != null){
            curr_old.next = curr_old.next.next;
            curr_new.next = curr_new.next != null ? curr_new.next.next : null;
            curr_old = curr_old.next;
            curr_new = curr_new.next;
        }

        return new_head;
    }

    public static void main(String[] args) {
        
    }
}
