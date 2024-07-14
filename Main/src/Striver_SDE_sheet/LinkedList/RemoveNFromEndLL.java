package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNFromEndLL{

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }

        if(head.next == null && n == 1){
            return head.next;
        }

        ListNode temp = head;
        int len = 1;

        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        temp = head;

        int pos = len - n - 1;

        if(pos < 0){
            return head.next;
        }

        while(pos > 0){
            temp = temp.next;
            pos--;
        }
        
        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(4);
        list = list.next;
        list.next = new ListNode(5);

        ListNode ans = removeNthFromEnd(head, 3);

        System.out.println(ans.val);
        System.out.println(ans.next.val);
        System.out.println(ans.next.next.val);
        System.out.println(ans.next.next.next.val);

    }
}