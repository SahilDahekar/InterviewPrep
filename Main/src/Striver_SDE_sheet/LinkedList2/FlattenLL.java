package LinkedList2;

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

public class FlattenLL {
    public static Node flatten(Node root) {
        // Your code here
        if(root == null || root.next == null){
            return root;
        }
        
        Node mergedRoot = flatten(root.next);
        root = merge(root, mergedRoot);
        return root;
    }
    
    public static Node merge(Node list1, Node list2){
        Node dummy = new Node(-1);
        Node res = dummy;
        
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            } else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }
        
        if(list1 == null){
            res.bottom = list2;
        } else {
            res.bottom = list1;
        }
        
        if(dummy.bottom != null){
            dummy.bottom.next = null;
        }
        
        return dummy.bottom;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.bottom = new Node(14);

        head.next = new Node(10);
        head.next.bottom = new Node(4);

        head.next.next = new Node(12);
        head.next.next.bottom = new Node(20);
        head.next.next.bottom.bottom = new Node(13);

        head.next.next.next = new Node(7);
        head.next.next.next.bottom = new Node(17);

        Node ans = flatten(head);

        System.out.println(ans.data);
        System.out.println(ans.bottom.data);
        System.out.println(ans.bottom.bottom.data);
        
    }
}
