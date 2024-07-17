package LinkedListAndArrays;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RotateLL {

    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        int length = 1;
        while(temp.next != null){
            temp = temp.next;
            length++;
        }

        temp.next = head;
        temp = temp.next;

        int rotations = k % length;
        int skip = length - rotations;

        for(int i = 0; i < skip - 1; i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        return head;

    }

    public static void main(String[] args){
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(4);
        list = list.next;
        list.next = new ListNode(5);
        
        int k = 2;

        ListNode ans = rotateRight(head, k);

        System.out.println(ans.val);
        System.out.println(ans.next.val);
        System.out.println(ans.next.next.val);
    }
}
