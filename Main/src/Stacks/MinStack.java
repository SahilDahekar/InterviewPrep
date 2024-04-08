package Stacks;

public class MinStack {
    private class Node{
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        // first Node will point to null and min is the val only
        if(head == null){
            head = new Node(val, val, null);
        }
        else {
            // this expression it will evaluate first the right side and then update the head
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    // simply move head to next pointer
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    // at every node min value is stored
    public int getMin() {
        return head.min;
    }
}
